/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.MenuItem;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author steph18
 */
@Transactional
public class MenuItemDao extends RepositoryDao<MenuItem, Long> {

    public MenuItemDao() {
        super(MenuItem.class);
    }

    //    public Map<String, MenuItem> getExistingMenuItems() {
//        return em.createQuery(
//                """
//                                SELECT mi FROM MenuItem mi
//                                                LEFT JOIN FETCH mi.menu
//                                                LEFT JOIN FETCH mi.parentItem
//                                                LEFT JOIN FETCH mi.permission
//
//                                """, MenuItem.class)
//                .getResultStream()
//                .collect(Collectors.toMap(MenuItem::getCode,
//                        c -> c,
//                        (existing, duplicate) -> existing
//                ));
//
//    }
    public Map<String, MenuItem> getExistingMenuItems() {
        return em.createQuery(
                        "SELECT m FROM MenuItem m LEFT JOIN FETCH m.permission LEFT JOIN FETCH m.parentItem",
                        MenuItem.class)
                .getResultStream()
                .collect(Collectors.toMap(
                        mi -> buildItemKey(mi),
                        mi -> mi,
                        (existing, duplicate) -> existing // ignore duplicates (devrait pas arriver si clé unique correcte)
                ));
    }

    private String buildItemKey(MenuItem mi) {
        return mi.getMenu().getCode() + ":"
                + (mi.getParentItem() != null ? mi.getParentItem().getCode() + ":" : "")
                + mi.getCode();
    }

    @Override
    public List<MenuItem> getAll() {
        return em.createQuery("""
                            SELECT i FROM MenuItem i
                            LEFT JOIN FETCH i.permission
                            LEFT JOIN FETCH i.parentItem
                            LEFT JOIN FETCH i.items
                            order by i.label
                        """, MenuItem.class)
                .getResultList();
    }


}
