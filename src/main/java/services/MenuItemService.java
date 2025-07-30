/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.MenuItemDao;
import dao.RepositoryDao;
import entities.MenuItem;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import service.interfaces.MenuItemServiceLocal;

/**
 * @author steph18
 */
@Transactional
@RequestScoped
public class MenuItemService extends GenericServiceLocalImpl<MenuItem, Long> implements MenuItemServiceLocal {

    @Inject
    private MenuItemDao dao;

    @Override
    protected RepositoryDao<MenuItem, Long> getDAO() {
        return dao;
    }

}
