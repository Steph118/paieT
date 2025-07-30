/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.Menu;
import java.util.Map;

/**
 * @author steph18
 */
public interface MenuServiceLocal extends GenericServiceLocal<Menu, Long> {

    public Map<String, Menu> getExistingMenus();

}
