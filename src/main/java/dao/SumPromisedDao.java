/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.SumPromised;
import jakarta.ejb.Stateless;

/**
 * @author steph18
 */
@Stateless
public class SumPromisedDao extends RepositoryDao<SumPromised, Integer> {

    public SumPromisedDao() {
        super(SumPromised.class);
    }

}
