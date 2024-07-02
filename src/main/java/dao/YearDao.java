/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Year;

/**
 * @author steph18
 */
public class YearDao extends RepositoryDao<Year, Integer> {

    public YearDao(Class<Year> entityClass) {
        super(entityClass);
    }

}
