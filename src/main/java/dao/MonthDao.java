/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.MonthEntity;
import entities.SumPromised;
import jakarta.ejb.Stateless;

import java.util.List;

/**
 * @author steph18
 */
@Stateless
public class MonthDao extends RepositoryDao<MonthEntity, Integer> {

    public MonthDao() {
        super(MonthEntity.class);
    }

    public List<MonthEntity> findMontNotPaid(SumPromised s) {
        String jpql = """
                SELECT m FROM MonthEntity m
                WHERE m NOT IN (
                SELECT DISTINCT sp.month 
                FROM SumPaid sp 
                JOIN sp.payments p 
                WHERE sp.sumPromised = :sumPromised
                GROUP BY sp.month 
                HAVING SUM(p.amount) >= :amount )
                """;
        return this.em.createQuery(jpql, MonthEntity.class)
                .setParameter("amount", s.getMontant())
                .setParameter("sumPromised", s)
                .getResultList();
    }
}
