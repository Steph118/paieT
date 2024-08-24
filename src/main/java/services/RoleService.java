/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import dao.RoleDao;
import dao.UserDao;
import entities.Role;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.RoleServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class RoleService extends GenericServiceLocalImpl<Role, Integer> implements RoleServiceLocal {

    @EJB
    private RoleDao dao;

    @Override
    protected RepositoryDao<Role, Integer> getDAO() {
        return dao;
    }

}
