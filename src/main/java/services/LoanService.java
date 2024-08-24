/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.LoanDao;
import dao.RepositoryDao;
import entities.Loan;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.LoanServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class LoanService extends GenericServiceLocalImpl<Loan, Integer> implements LoanServiceLocal {

    @EJB
    private LoanDao dao;

    @Override
    protected RepositoryDao<Loan, Integer> getDAO() {
        return dao;
    }

}
