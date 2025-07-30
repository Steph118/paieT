/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Menu;
import jakarta.transaction.Transactional;
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

    public Map<String, Menu> getExistingMenus() {
        Map<String, Menu> existingCategories = em.createQuery(
                "SELECT m FROM Menu m LEFT JOIN FETCH m.items", Menu.class)
                .getResultStream()
                .collect(Collectors.toMap(Menu::getCode, c -> c));
        return existingCategories;
    }

}
