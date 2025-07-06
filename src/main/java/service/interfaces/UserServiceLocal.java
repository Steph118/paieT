/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.User;

import java.util.Optional;
import java.util.Set;

/**
 * @author steph18
 */
public interface UserServiceLocal extends GenericServiceLocal<User, Integer> {

    String hashPassword(String password);

    User updateWithPassword(User user);

    Optional<User> findByUsernameAndPassword(String username, String password);

    Set<String> findRolesForUser(User user);

    User findByUsername(String username);

    boolean hasPermission(String username, String resource, String action);
}
