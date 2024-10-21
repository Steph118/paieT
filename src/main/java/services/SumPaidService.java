/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import dao.SumPaidDao;
import entities.Member;
import entities.SumPaid;
import entities.SumPromised;
import enumeration.Month;
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

    @Override
    public SumPaid findBy(Member member, SumPromised sumPromised, Month month) {
        return null;
    }
}
