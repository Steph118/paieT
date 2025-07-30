/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.PermissionCategoryDao;
import dao.RepositoryDao;
import entities.PermissionCategory;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.Map;
import service.interfaces.PermissionCategoryServiceLocal;

/**
 * @author steph18
 */
@Transactional
@RequestScoped
public class PermissionCategoryService extends GenericServiceLocalImpl<PermissionCategory, Long> implements
        PermissionCategoryServiceLocal {

    @Inject
    private PermissionCategoryDao dao;

    @Override
    protected RepositoryDao<PermissionCategory, Long> getDAO() {
        return dao;
    }

    @Override
    public Map<String, PermissionCategory> getExistingCategories() {
        return dao.getExistingCategories();
    }

}
