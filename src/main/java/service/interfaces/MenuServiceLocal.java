/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.Menu;

import java.util.List;
import java.util.Map;
import menu.MenuItem;

/**
 * @author steph18
 */
public interface MenuServiceLocal extends GenericServiceLocal<Menu, Long> {

    Map<String, Menu> getExistingMenus();

    List<Menu> loadMenusWithHierarchy();

}
