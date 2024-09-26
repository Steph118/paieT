/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classutils;

import entities.User;
import jakarta.security.enterprise.CallerPrincipal;

/**
 *
 * @author steph18
 */
public class UserPrincipal extends CallerPrincipal {

    private final User user;

    public UserPrincipal(User user) {
        super(user.getUserName());
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
