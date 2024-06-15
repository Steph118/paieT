/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.CountryDao;
import dao.RepositoryDao;
import entities.Country;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.CountryServiceLocal;

/**
 *
 * @author steph18
 */
@Stateless
public class CountryService extends GenericServiceLocalImpl<Country, Integer> 
implements CountryServiceLocal{

    @EJB
    private CountryDao dao;

    @Override
    protected RepositoryDao<Country, Integer> getDAO() {
        return dao;
    }    

}
