/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.MenuItem;

import java.util.Map;

/**
 * @author steph18
 */
public interface MenuItemServiceLocal extends GenericServiceLocal<MenuItem, Long> {

    Map<String, MenuItem> getExistingMenuItems();

}
