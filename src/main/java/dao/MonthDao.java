/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Member;
import enumeration.Month;
import jakarta.ejb.Stateless;

/**
 * @author steph18
 */
@Stateless
public class MonthDao extends RepositoryDao<Month, Integer> {

    public MonthDao() {
        super(Month.class);
    }

}
