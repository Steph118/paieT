/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import dao.RoleDao;
import entities.Role;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import service.interfaces.RoleServiceLocal;

/**
 * @author steph18
 */
@RequestScoped
public class RoleService extends GenericServiceLocalImpl<Role, Integer> implements RoleServiceLocal {

    @Inject
    private RoleDao dao;

    @Override
    protected RepositoryDao<Role, Integer> getDAO() {
        return dao;
    }

}
