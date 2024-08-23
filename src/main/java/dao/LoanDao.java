/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Loan;
import jakarta.ejb.Stateless;

/**
 * @author steph18
 */
@Stateless
public class LoanDao extends RepositoryDao<Loan, Integer> {

    public LoanDao() {
        super(Loan.class);
    }

}
