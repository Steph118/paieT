/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.SumPaid;
import jakarta.ejb.Stateless;

/**
 * @author steph18
 */
@Stateless
public class SumPaidDao extends RepositoryDao<SumPaid, Integer> {

    public SumPaidDao() {
        super(SumPaid.class);
    }

}
