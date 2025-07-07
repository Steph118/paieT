/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Country;
import jakarta.transaction.Transactional;

/**
 * @author steph18
 */
@Transactional
public class CountryDao extends RepositoryDao<Country, Integer> {

    public CountryDao() {
        super(Country.class);
    }

}
