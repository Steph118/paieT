/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.User;
import jakarta.ejb.Local;

/**
 * @author steph18
 */
@Local
public interface UserServiceLocal extends GenericServiceLocal<User, Integer> {
}
