/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.MenuDao;
import dao.RepositoryDao;
import entities.Menu;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;
import menu.config.MenuItem;
import service.interfaces.MenuServiceLocal;

/**
 * @author steph18
 */
@Transactional
@RequestScoped
public class MenuService extends GenericServiceLocalImpl<Menu, Long> implements MenuServiceLocal {

    @Inject
    private MenuDao dao;

    @Override
    protected RepositoryDao<Menu, Long> getDAO() {
        return dao;
    }

    @Override
    public Map<String, Menu> getExistingMenus() {
        return dao.getExistingMenus();
    }

    @Override
    public List<Menu> loadMenusWithHierarchy() {
        return dao.loadMenusWithHierarchy();
    }

}
