/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.PermisionDao;
import dao.RepositoryDao;
import dao.RoleDao;
import entities.Permission;
import entities.Role;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.PermissionServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class PermissionService extends GenericServiceLocalImpl<Permission, Integer> implements PermissionServiceLocal {

    @EJB
    private PermisionDao dao;

    @Override
    protected RepositoryDao<Permission, Integer> getDAO() {
        return dao;
    }

}
