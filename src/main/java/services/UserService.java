/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import dao.UserDao;
import dao.YearDao;
import entities.User;
import entities.Year;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.UserServiceLocal;
import service.interfaces.YearServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class UserService extends GenericServiceLocalImpl<User, Integer> implements UserServiceLocal {

    @EJB
    private UserDao dao;

    @Override
    protected RepositoryDao<User, Integer> getDAO() {
        return dao;
    }

}
