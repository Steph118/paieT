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

/**
 * @author steph18
 */
@Stateless
public class SumPromisedDao extends RepositoryDao<SumPromised, Integer> {

    public SumPromisedDao() {
        super(SumPromised.class);
    }

    public SumPromised findBy(Member m, Loan l, Year y) {
        return null;
    }

}
