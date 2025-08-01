/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.Permission;

import java.util.Map;
import java.util.Optional;

/**
 * @author steph18
 */
public interface PermissionServiceLocal extends GenericServiceLocal<Permission, Long> {

    Optional<Permission> getByCode(String code);

    Map<String, Permission> getExistingPermissions();
}
