/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Member;
import entities.MonthEntity;
import entities.SumPaid;
import entities.SumPromised;
import jakarta.ejb.Stateless;
import jakarta.persistence.NoResultException;

import java.math.BigDecimal;

/**
 * @author steph18
 */
@Stateless
public class SumPaidDao extends RepositoryDao<SumPaid, Integer> {

    public SumPaidDao() {
        super(SumPaid.class);
    }

    public SumPaid findSumPaidBy(MonthEntity month, SumPromised sumPromised, Member member) {
        String jpql = """
                                SELECT sp
                                FROM SumPaid sp
                                WHERE sp.month = :month
                                AND sp.sumPromised = :sumPromised
                                AND sp.member = :member
                """;
        try {
            return this.em.createQuery(jpql, SumPaid.class)
                    .setParameter("month", month)
                    .setParameter("sumPromised", sumPromised)
                    .setParameter("member", member)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    public BigDecimal totalSumPaid(SumPaid sp) {
        String jpql = """
                                SELECT SUM (p.amount)
                                FROM Payment p
                                WHERE p.sumPaid = :sumPaid
                """;
        try {
            return this.em.createQuery(jpql, BigDecimal.class)
                    .setParameter("sumPaid", sp)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    public Boolean verifyPayment(SumPromised s) {
        return true;
    }
}
