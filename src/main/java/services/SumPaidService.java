/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import dao.SumPaidDao;
import entities.Member;
import entities.MonthEntity;
import entities.SumPaid;
import entities.SumPromised;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.SumPaidServiceLocal;

import java.math.BigDecimal;

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
    public SumPaid findSumPaidBy(MonthEntity month, SumPromised sumPromised, Member member) {
        return this.dao.findSumPaidBy(month, sumPromised, member);
    }

    @Override
    public BigDecimal totalSumPaid(SumPaid sp) {
        return this.dao.totalSumPaid(sp);

    }
}
