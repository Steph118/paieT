/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.PermisionDao;
import dao.RepositoryDao;
import entities.Permission;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import service.interfaces.PermissionServiceLocal;

import java.util.Map;
import java.util.Optional;

/**
 * @author steph18
 */
@Transactional
@RequestScoped
public class PermissionService extends GenericServiceLocalImpl<Permission, Long> implements PermissionServiceLocal {

    @Inject
    private PermisionDao dao;

    @Override
    protected RepositoryDao<Permission, Long> getDAO() {
        return dao;
    }

    @Override
    public Optional<Permission> getByCode(String code) {
        return dao.getByCode(code);
    }

    @Override
    public Map<String, Permission> getExistingPermissions() {
        return dao.getExistingPermissions();
    }

}
