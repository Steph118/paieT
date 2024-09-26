/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import dao.SumPaidDao;
import entities.SumPaid;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.SumPaidServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class SumPaidService extends GenericServiceLocalImpl<SumPaid, Integer> implements SumPaidServiceLocal {

    @EJB
    private SumPaidDao dao;

    @Override
    protected RepositoryDao<SumPaid, Integer> getDAO() {
        return dao;
    }
}
