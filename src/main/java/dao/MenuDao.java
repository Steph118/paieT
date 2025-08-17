/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Menu;
import entities.MenuItem;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author steph18
 */
@Transactional
public class MenuDao extends RepositoryDao<Menu, Long> {

    public MenuDao() {
        super(Menu.class);
    }

    public List<Menu> loadMenusWithHierarchy() {
        List<Menu> menus = em.createQuery("SELECT m FROM Menu m order by m.label", Menu.class)
                .getResultList();

        for (Menu menu : menus) {
            List<MenuItem> flatItems = em.createQuery("""
                                SELECT i FROM MenuItem i
                                LEFT JOIN FETCH i.permission
                                WHERE i.menu = :menu
                                order by i.order
                            """, MenuItem.class)
                    .setParameter("menu", menu)
                    .getResultList();

            buildHierarchy(flatItems, menu);
        }

        return menus;
    }

    private void buildHierarchy(List<MenuItem> flatItems, Menu menu) {
        Map<Long, MenuItem> idToItem = new HashMap<>();
        List<MenuItem> rootItems = new ArrayList<>();

        // Indexation des items
        for (MenuItem item : flatItems) {
            idToItem.put(item.getId(), item);
            item.setItems(new ArrayList<>()); // reset children
        }

        // Reconstruction de la hiérarchie
        for (MenuItem item : flatItems) {
            if (item.getParentItem() != null && item.getParentItem().getId() != null) {
                MenuItem parent = idToItem.get(item.getParentItem().getId());
                if (parent != null) {
                    parent.getItems().add(item);
                }
            } else {
                rootItems.add(item); // item racine
            }
        }

        // Injecter les racines dans le menu
        menu.setItems(rootItems);
    }

    public Map<String, Menu> getExistingMenus() {
        return em.createQuery("SELECT m FROM Menu m", Menu.class)
                .getResultStream()
                .collect(Collectors.toMap(Menu::getCode, m -> m));
    }

}
