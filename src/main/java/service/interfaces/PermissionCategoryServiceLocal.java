/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.PermissionCategory;

import java.util.Map;

/**
 * @author steph18
 */
public interface PermissionCategoryServiceLocal extends GenericServiceLocal<PermissionCategory, Long> {

    Map<String, PermissionCategory> getExistingCategoriesPermissions();
}
