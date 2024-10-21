/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Loan;
import entities.Member;
import entities.SumPromised;
import entities.Year;
import jakarta.ejb.Stateless;
import jakarta.persistence.NoResultException;

/**
 * @author steph18
 */
@Stateless
public class SumPromisedDao extends RepositoryDao<SumPromised, Integer> {

    public SumPromisedDao() {
        super(SumPromised.class);
    }

    public SumPromised findBy(Member m, Loan l, Year y) {
        String jpql = "SELECT e FROM " + this.getEntityClassName()
                + " e WHERE e.member.id = :memberId AND e.year.id = :yearId AND e.loan.id = :loanId";
        try {
            return this.em.createQuery(jpql, this.getEntityClass())
                    .setParameter("memberId", m.getId())
                    .setParameter("yearId", y.getId())
                    .setParameter("loanId", l.getId())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
