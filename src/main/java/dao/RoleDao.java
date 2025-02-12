/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Role;
import jakarta.transaction.Transactional;

/**
 * @author steph18
 */
@Transactional
public class RoleDao extends RepositoryDao<Role, Integer> {

    public RoleDao() {
        super(Role.class);
    }

}
