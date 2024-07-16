/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import dao.TypeLocalityDao;
import entities.TypeLocality;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.TypeLocalityServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class TypeLocalityService extends GenericServiceLocalImpl<TypeLocality, Integer> implements TypeLocalityServiceLocal {

    @EJB
    private TypeLocalityDao dao;

    @Override
    protected RepositoryDao<TypeLocality, Integer> getDAO() {
        return dao;
    }

}
