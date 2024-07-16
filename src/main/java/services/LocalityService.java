/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.LocalityDao;
import dao.RepositoryDao;
import entities.Locality;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.LocalityServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class LocalityService extends GenericServiceLocalImpl<Locality, Integer> implements LocalityServiceLocal {

    @EJB
    private LocalityDao dao;

    @Override
    protected RepositoryDao<Locality, Integer> getDAO() {
        return dao;
    }

}
