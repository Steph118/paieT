/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.CountryDao;
import dao.RepositoryDao;
import entities.Country;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import service.interfaces.CountryServiceLocal;

/**
 * @author steph18
 */
@Transactional
@RequestScoped
public class CountryService extends GenericServiceLocalImpl<Country, Integer> implements CountryServiceLocal {

    @Inject
    private CountryDao dao;

    @Override
    protected RepositoryDao<Country, Integer> getDAO() {
        return dao;
    }
}
