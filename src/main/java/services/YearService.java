/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import dao.YearDao;
import entities.Year;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import service.interfaces.YearServiceLocal;

/**
 * @author steph18
 */
@Transactional
@RequestScoped
public class YearService extends GenericServiceLocalImpl<Year, Integer> implements YearServiceLocal {

    @Inject
    private YearDao dao;

    @Override
    protected RepositoryDao<Year, Integer> getDAO() {
        return dao;
    }

}
