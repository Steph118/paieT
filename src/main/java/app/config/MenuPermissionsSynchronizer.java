package app.config;

import entities.*;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import menu.config.Config;
import menu.config.ConfigMenu;
import menu.config.ConfigMenuItem;
import menu.config.ConfigPermissionCategory;
import org.yaml.snakeyaml.Yaml;
import service.interfaces.*;

import java.io.InputStream;
import java.security.MessageDigest;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Startup
public class MenuPermissionsSynchronizer {

    private static final Logger LOGGER = Logger.getLogger(MenuPermissionsSynchronizer.class.getName());

    @Inject
    private PermissionCategoryServiceLocal categoryService;
    @Inject
    private PermissionServiceLocal permissionService;
    @Inject
    private MenuServiceLocal menuService;
    @Inject
    private MenuItemServiceLocal menuItemService;
    @Inject
    private UserServiceLocal userService;

    private String lastConfigHash;

    @PostConstruct
    public void init() {
        synchronizeConfig();
        adduserDefault();

    }

    private void adduserDefault() {

        Optional<Permission> p = permissionService.getByCode("perm.all");
        p.ifPresent(permission -> userService.findByUsername("sadmin")
                .ifPresentOrElse((t) -> {
                            userService.findPermissionsForUser(t).forEach((u) -> {
                                System.err.println("u : " + u);
                            });
                            LOGGER.info("sadmin exite.");
                        },
                        () -> {
                            User sadmin = User.instance().createAdmin("sadmin", "admin$235")
                                    .addRole(Role.instance().addLabel("Super Admin")
                                            .addPermission(permission));
                            userService.save(sadmin);
                            LOGGER.info("sadmin creer.");
                        }));

    }

    private void synchronizeConfig() {
        LOGGER.info("Synchronisation des menus et permissions");
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("config/config.yaml")) {
            if (in == null) {
                LOGGER.info("Fichier de configuration non trouvé.");
                return;
            }
            String currentHash = calculateHash(in);
            if (currentHash.equals(lastConfigHash)) {
                LOGGER.info("Aucune modification détectée dans la configuration.");
                return;
            }
            in.reset();
            Config config = new Yaml().loadAs(in, Config.class);
            LOGGER.info("Fichier yaml de la configuration mappé...");
            Map<String, PermissionCategory> existingCategories = categoryService.getExistingCategoriesPermissions();
            Map<String, Permission> existingPermissions = permissionService.getExistingPermissions();
            Map<String, Menu> existingMenus = menuService.getExistingMenus();
            Map<String, MenuItem> existingMenuItems = menuItemService.getExistingMenuItems();
            synchronizePermissions(config.getPermission_categories(), existingCategories, existingPermissions);
            synchronizeMenus(config.getMenus(), existingMenus, existingMenuItems, existingPermissions);
            lastConfigHash = currentHash;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erreur de synchronisation:", e);
        }
    }

    private void synchronizePermissions(List<ConfigPermissionCategory> yamlCategories,
                                        Map<String, PermissionCategory> existingCategories,
                                        Map<String, Permission> existingPermissions) {
        Set<String> yamlPermissionCodes = new HashSet<>();
        Set<String> yamlCategoryCodes = new HashSet<>();

        List<PermissionCategory> toCreateCat = new ArrayList<>();
        List<PermissionCategory> toUpdateCat = new ArrayList<>();
        List<PermissionCategory> toRemoveCat = new ArrayList<>();
        List<Permission> toCreatePerm = new ArrayList<>();
        List<Permission> toUpdatePerm = new ArrayList<>();
        List<Permission> toRemovePerm = new ArrayList<>();

        for (var catConfig : yamlCategories) {
            yamlCategoryCodes.add(catConfig.getCode());
            PermissionCategory cat = existingCategories.get(catConfig.getCode());

            if (cat == null) {
                cat = new PermissionCategory(catConfig.getCode(), catConfig.getLabel());
                toCreateCat.add(cat);
                existingCategories.put(cat.getCode(), cat);
            } else if (!Objects.equals(cat.getLabel(), catConfig.getLabel())) {
                cat.setLabel(catConfig.getLabel());
                toUpdateCat.add(cat);
            }

            for (var permConfig : catConfig.getPermissions()) {
                yamlPermissionCodes.add(permConfig.getCode());
                Permission perm = existingPermissions.get(permConfig.getCode());

                if (perm == null) {
                    perm = new Permission(permConfig.getCode(), permConfig.getLabel(), cat);
                    toCreatePerm.add(perm);
                    existingPermissions.put(perm.getCode(), perm);
                } else {
                    boolean updated = false;
                    if (!Objects.equals(perm.getLabel(), permConfig.getLabel())) {
                        perm.setLabel(permConfig.getLabel());
                        updated = true;
                    }
                    // Attention au nom exact du setter dans Permission (ex: setCategoryPermission)
                    if (!Objects.equals(perm.getCategoryPermission(), cat)) {
                        perm.setCategoryPermission(cat);
                        updated = true;
                    }
                    if (updated) {
                        toUpdatePerm.add(perm);
                    }
                }
            }
        }

        // Suppressions
        existingCategories.values().stream()
                .filter(cat -> !yamlCategoryCodes.contains(cat.getCode()))
                .forEach(toRemoveCat::add);

        existingPermissions.values().stream()
                .filter(perm -> !yamlPermissionCodes.contains(perm.getCode()))
                .forEach(toRemovePerm::add);

        batchSavePermissions(toCreateCat, toUpdateCat, toRemoveCat, toCreatePerm, toUpdatePerm, toRemovePerm);
    }

    private void synchronizeMenus(List<ConfigMenu> yamlMenus,
                                  Map<String, Menu> existingMenus,
                                  Map<String, MenuItem> existingItems,
                                  Map<String, Permission> existingPermissions) {
        Set<String> yamlMenuCodes = new HashSet<>();
        Set<String> yamlItemKeys = new HashSet<>();

        List<Menu> toCreateMenu = new ArrayList<>();
        List<Menu> toUpdateMenu = new ArrayList<>();
        List<Menu> toRemoveMenu = new ArrayList<>();
        List<MenuItem> toCreateItem = new ArrayList<>();
        List<MenuItem> toUpdateItem = new ArrayList<>();
        List<MenuItem> toRemoveItem = new ArrayList<>();

        for (var menuConfig : yamlMenus) {
            yamlMenuCodes.add(menuConfig.getCode());
            Menu menu = existingMenus.get(menuConfig.getCode());

            if (menu == null) {
                menu = new Menu(menuConfig.getCode(), menuConfig.getLabel());
                toCreateMenu.add(menu);
                existingMenus.put(menu.getCode(), menu);
            } else if (!Objects.equals(menu.getLabel(), menuConfig.getLabel())) {
                menu.setLabel(menuConfig.getLabel());
                toUpdateMenu.add(menu);
            }

            processMenuItems(menu, menuConfig.getItems(), null, existingItems, existingPermissions,
                    yamlItemKeys, toCreateItem, toUpdateItem);
        }

        // Suppressions menus
        existingMenus.values().stream()
                .filter(menu -> !yamlMenuCodes.contains(menu.getCode()))
                .forEach(toRemoveMenu::add);

        // Suppressions menu items
        existingItems.keySet().stream()
                .filter(key -> !yamlItemKeys.contains(key))
                .map(existingItems::get)
                .forEach(toRemoveItem::add);

        batchSaveMenus(toCreateMenu, toUpdateMenu, toRemoveMenu, toCreateItem, toUpdateItem, toRemoveItem);
    }

    private void processMenuItems(Menu menu, List<ConfigMenuItem> items, MenuItem parent,
                                  Map<String, MenuItem> existingItems,
                                  Map<String, Permission> permissions,
                                  Set<String> yamlKeys,
                                  List<MenuItem> toCreate, List<MenuItem> toUpdate) {
        for (var config : items) {
            String key = buildItemKey(menu.getCode(), parent, config.getCode());
            yamlKeys.add(key);

            MenuItem item = existingItems.get(key);
            if (item == null) {
                item = new MenuItem(config, menu, parent, getPermission(config.getRequiredPermission(), permissions));
                toCreate.add(item);
                existingItems.put(key, item);
            } else if (hasItemChanged(item, config, permissions)) {
                updateMenuItem(item, config, permissions);
                toUpdate.add(item);
            }

            if (config.getItems() != null) {
                processMenuItems(menu, config.getItems(), item, existingItems, permissions,
                        yamlKeys, toCreate, toUpdate);
            }
        }
    }

    private boolean hasItemChanged(MenuItem item, ConfigMenuItem config, Map<String, Permission> permissions) {
        return !Objects.equals(item.getLabel(), config.getLabel())
                || !Objects.equals(item.getPath(), config.getPath())
                || !Objects.equals(item.getIcon(), config.getIcon())
                || !Objects.equals(item.getPermission(), getPermission(config.getRequiredPermission(), permissions));
    }

    private void updateMenuItem(MenuItem item, ConfigMenuItem config, Map<String, Permission> permissions) {
        item.setLabel(config.getLabel());
        item.setPath(config.getPath());
        item.setIcon(config.getIcon());
        item.setPermission(getPermission(config.getRequiredPermission(), permissions));
    }

    private void batchSavePermissions(List<PermissionCategory> toCreateCat, List<PermissionCategory> toUpdateCat,
                                      List<PermissionCategory> toRemoveCat, List<Permission> toCreatePerm,
                                      List<Permission> toUpdatePerm, List<Permission> toRemovePerm) {
        if (!toCreateCat.isEmpty()) {
            categoryService.saveAll(toCreateCat);
        }
        if (!toUpdateCat.isEmpty()) {
            categoryService.updateAll(toUpdateCat);
        }
        if (!toRemoveCat.isEmpty()) {
            categoryService.deleteAll(toRemoveCat);
        }
        if (!toCreatePerm.isEmpty()) {
            permissionService.saveAll(toCreatePerm);
        }
        if (!toUpdatePerm.isEmpty()) {
            permissionService.updateAll(toUpdatePerm);
        }
        if (!toRemovePerm.isEmpty()) {
            permissionService.deleteAll(toRemovePerm);
        }
    }

    private void batchSaveMenus(List<Menu> toCreateMenu, List<Menu> toUpdateMenu, List<Menu> toRemoveMenu,
                                List<MenuItem> toCreateItem, List<MenuItem> toUpdateItem, List<MenuItem> toRemoveItem) {
        if (!toCreateMenu.isEmpty()) {
            menuService.saveAll(toCreateMenu);
        }
        if (!toUpdateMenu.isEmpty()) {
            menuService.updateAll(toUpdateMenu);
        }
        if (!toRemoveMenu.isEmpty()) {
            menuService.deleteAll(toRemoveMenu);
        }
        if (!toCreateItem.isEmpty()) {
            menuItemService.saveAll(toCreateItem);
        }
        if (!toUpdateItem.isEmpty()) {
            menuItemService.updateAll(toUpdateItem);
        }
        if (!toRemoveItem.isEmpty()) {
            menuItemService.deleteAll(toRemoveItem);
        }
    }

    private String calculateHash(InputStream in) throws Exception {
        byte[] hash = MessageDigest.getInstance("SHA-256").digest(in.readAllBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    private String buildItemKey(String menuCode, MenuItem parent, String itemCode) {
        return menuCode + ":"
                + (parent != null ? parent.getCode() + ":" : "")
                + itemCode;
    }

    private Permission getPermission(String code, Map<String, Permission> existingPermissions) {
        return code != null ? existingPermissions.get(code) : null;
    }
}
