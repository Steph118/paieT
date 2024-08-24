/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.MonthDao;
import dao.RepositoryDao;
import enumeration.Month;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.MonthServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class MonthService extends GenericServiceLocalImpl<Month, Integer> implements MonthServiceLocal {

    @EJB
    private MonthDao dao;

    @Override
    protected RepositoryDao<Month, Integer> getDAO() {
        return dao;
    }

}
