/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu.config;

import entities.Menu;
import entities.MenuItem;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import service.interfaces.MenuItemServiceLocal;
import service.interfaces.MenuServiceLocal;




/**
 * @author steph18
 */
@ApplicationScoped
@Named
public class AppMenu2 {

    private static final Logger LOGGER = Logger.getLogger(AppMenu2.class.getName());

    private List<Menu> menus = new ArrayList<>();
    private List<MenuItem> menuItems = new ArrayList<>();

    @Inject
    private MenuServiceLocal menuService;
    @Inject
    private MenuItemServiceLocal menuItemService;

    @PostConstruct
    public void init() {
        LOGGER.info("Loading Menu 2...");
        menus = menuService.loadMenusWithHierarchy();
        menuItems = menuItemService.getAll();
    }

    public List<MenuItem> completeMenuItem(String query) {
        String queryLowerCase = query.toLowerCase();
        List<MenuItem> filteredItems = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.getPath() != null
                    && (item.getLabel().toLowerCase().contains(queryLowerCase) || anyParentContainsQuery(item, queryLowerCase))) {
                filteredItems.add(item);
            } else if (item.getBadge() != null) {
                if (item.getBadge().toLowerCase().contains(queryLowerCase)) {
                    filteredItems.add(item);
                }
            }
        }
        filteredItems.sort(Comparator.comparing(m -> m.getParentItem()!= null ? m.getParentItem().getLabel() : ""));
        return filteredItems;
    }
    
    protected boolean anyParentContainsQuery(MenuItem item, String query) {
        MenuItem parent = item.getParentItem();
        while (parent != null) {
            if (parent.getLabel().toLowerCase().contains(query)) {
                return true;
            }
            parent = parent.getParentItem();
        }

        return false;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

}
