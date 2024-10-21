/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Eglise;
import entities.Loan;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 * @author steph18
 */
@Stateless
public class LoanDao extends RepositoryDao<Loan, Integer> {

    public LoanDao() {
        super(Loan.class);
    }

    public List<Loan> getLoansByEglise(Eglise eglise) {
        String jpql = """ 
                      SELECT e FROM Loan e WHERE e.eglise = :eglise
                      """;
        return this.em.createQuery(jpql, this.getEntityClass())
                .setParameter("eglise", eglise)
                .getResultList();

    }

}
