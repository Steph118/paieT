/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import dao.YearDao;
import entities.Year;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.YearServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class YearService extends GenericServiceLocalImpl<Year, Integer> implements YearServiceLocal {

    @EJB
    private YearDao dao;

    @Override
    protected RepositoryDao<Year, Integer> getDAO() {
        return dao;
    }

}
