/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domains.audit;

import entities.User;

/**
 *
 * @author mawuli
 */
public class LoggedUser {

    private static final ThreadLocal<User> userHolder
            = new ThreadLocal<>();

    public static void setLoggedUser(User user) {
        userHolder.set(user);
    }

    public static void removeLoggedUser() {
        userHolder.remove();
    }

    public static User get() {
        return userHolder.get();
    }
}
