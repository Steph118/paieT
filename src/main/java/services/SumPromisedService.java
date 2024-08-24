/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import dao.SumPromisedDao;
import entities.SumPromised;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.SumPromisedServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class SumPromisedService extends GenericServiceLocalImpl<SumPromised, Integer> implements SumPromisedServiceLocal {

    @EJB
    private SumPromisedDao dao;

    @Override
    protected RepositoryDao<SumPromised, Integer> getDAO() {
        return dao;
    }

}
