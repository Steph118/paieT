/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Country;

/**
 *
 * @author steph18
 */
public class CountryDao extends RepositoryDao<Country, Integer> {

    @Override
    public Class<Country> getEntityClass() {
        return Country.class;
    }

    @Override
    public Integer getId(Country country) {
        return country.getId();
    }
    
}
