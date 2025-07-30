/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apps.test;

/**
 * @author steph18
 */

import entities.Menu;
import entities.MenuItem;
import entities.Permission;
import entities.PermissionCategory;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import org.yaml.snakeyaml.Yaml;
import service.interfaces.MenuItemServiceLocal;
import service.interfaces.MenuServiceLocal;
import service.interfaces.PermissionCategoryServiceLocal;
import service.interfaces.PermissionServiceLocal;

import java.io.InputStream;
import java.security.MessageDigest;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Singleton
@Startup
public class ConfigSynchronizer {

    @Inject
    private PermissionCategoryServiceLocal permissionCategoryService;
    @Inject
    private PermissionServiceLocal permissionService;
    @Inject
    private MenuServiceLocal menuService;
    @Inject
    private MenuItemServiceLocal menuItemService;

    private String lastConfigHash;
    private static final Logger LOGGER = Logger.getLogger(ConfigSynchronizer.class.getName());

    public ConfigSynchronizer() {
    }

    @PostConstruct
    public void synchronize() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("config/config.yaml")) {
            if (Objects.nonNull(in)) {
                String currentHash = calculateHash(in);
                // Vérifier si le fichier a changé
                if (currentHash.equals(lastConfigHash)) {
                    LOGGER.log(Level.INFO, "currentHash : {0} , lastConfigHash : {1}", new Object[]{currentHash, lastConfigHash});
                    return;
                }
                // Recharger le fichier pour le parsing
                in.reset();
                Config config = new Yaml().loadAs(in, Config.class);
                LOGGER.log(Level.INFO, "Config : {0}", config);
                // Synchronisation optimisée
                syncCategories(config.getPermission_categories());
                syncMenus(config.getMenus());
                // Mettre à jour le hash
                lastConfigHash = currentHash;
                return;
            }
            LOGGER.log(Level.INFO, "Fichier vide");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erreur de synchronisation",e);
        }
    }

    private String calculateHash(InputStream in) throws Exception {
        byte[] fileContent = in.readAllBytes();
        byte[] hash = MessageDigest.getInstance("SHA-256").digest(fileContent);
        return Base64.getEncoder().encodeToString(hash);
    }

    private void syncCategories(List<PermissionCategoryConfig> categories) {
        // Chargement batch des catégories existantes
        Map<String, PermissionCategory> existingCategories = permissionCategoryService.getExistingCategories();

        for (PermissionCategoryConfig categoryConfig : categories) {
            PermissionCategory category = existingCategories.computeIfAbsent(
                    categoryConfig.getCode(),
                    code -> {
                        PermissionCategory newCat = new PermissionCategory();
                        newCat.setCode(code);
                        //newCat.setLabel(categoryConfig.getLabel());
                        permissionCategoryService.save(newCat);
                        return newCat;
                    });

            // Mise à jour si nécessaire
            if (!category.getLabel().equals(categoryConfig.getLabel())) {
                category.setLabel(categoryConfig.getLabel());
                permissionCategoryService.update(category);
            }

            // Synchronisation des permissions
            syncPermissions(category, categoryConfig.getPermissions());
        }
    }

    private void syncPermissions(PermissionCategory category, List<PermissionConfig> permissions) {
        Map<String, Permission> existingPerms = category.getPermissions().stream()
                .collect(Collectors.toMap(Permission::getCode, p -> p));

        for (PermissionConfig permConfig : permissions) {
            Permission perm = existingPerms.computeIfAbsent(
                    permConfig.getCode(),
                    code -> {
                        Permission newPerm = new Permission();
                        newPerm.setCode(code);
                        //newPerm.setLabel(permConfig.getLabel());
                        newPerm.setCategoryPermission(category);
                        permissionService.save(newPerm);
                        return newPerm;
                    });

            if (!perm.getLabel().equals(permConfig.getLabel())) {
                perm.setLabel(permConfig.getLabel());
                permissionService.update(perm);
            }
        }
    }

    private void syncMenus(List<MenuConfig> menus) {
        Map<String, Menu> existingMenus = menuService.getExistingMenus();

        for (MenuConfig menuConfig : menus) {
            Menu menu = existingMenus.computeIfAbsent(
                    menuConfig.getCode(),
                    code -> {
                        Menu newMenu = new Menu();
                        newMenu.setCode(code);
                        //newMenu.setLabel(menuConfig.getLabel());
                        menuService.save(newMenu);
                        return newMenu;
                    }
            );

            if (!menu.getLabel().equals(menuConfig.getLabel())) {
                menu.setLabel(menuConfig.getLabel());
                menuService.update(menu);
            }

            syncMenuItems(menu, menuConfig.getItems(), null);
        }
    }

    private void syncMenuItems(Menu menu, List<MenuItemConfig> items, MenuItem parent) {
        Map<String, MenuItem> existingItems = menu.getItems().stream()
                .filter(item -> Objects.equals(item.getParentItem(), parent))
                .collect(Collectors.toMap(MenuItem::getCode, i -> i));

        for (MenuItemConfig itemConfig : items) {
            MenuItem item = existingItems.computeIfAbsent(
                    itemConfig.getCode(),
                    code -> {
                        MenuItem newItem = new MenuItem();
                        newItem.setCode(code);
                        newItem.setMenu(menu);
                        newItem.setParentItem(parent);
                        //newItem.setLabel(itemConfig.getLabel());
                        //newItem.setPath(itemConfig.getPath());
                        //newItem.setIcon(itemConfig.getIcon());
                        menuItemService.save(parent);
                        return newItem;
                    });

            boolean needsUpdate = !item.getLabel().equals(itemConfig.getLabel())
                    || !item.getPath().equals(itemConfig.getPath())
                    || !Objects.equals(item.getIcon(), itemConfig.getIcon());

            if (needsUpdate) {
                item.setLabel(itemConfig.getLabel());
                item.setPath(itemConfig.getPath());
                item.setIcon(itemConfig.getIcon());
                menuItemService.update(item);
            }

            // Gestion de la permission
            if (itemConfig.getRequiredPermission() != null) {
                Optional<Permission> p = permissionService.getByCode(itemConfig.getRequiredPermission());
                if (p.isPresent()) {
                    Permission perm = p.get();
                    if (!perm.equals(item.getPermission())) {
                        item.setPermission(perm);
                        menuItemService.update(item);

                    }
                }

            }

            // Traitement récursif
            syncMenuItems(menu, itemConfig.getChildren(), item);
        }
    }
}
