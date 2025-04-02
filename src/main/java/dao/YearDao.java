/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Year;
import jakarta.ejb.Stateless;

/**
 * @author steph18
 */
@Stateless
public class YearDao extends RepositoryDao<Year, Integer> {

    public YearDao() {
        super(Year.class);
    }

}
