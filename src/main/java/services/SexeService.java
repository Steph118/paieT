/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import dao.SexeDao;
import entities.Sexe;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import service.interfaces.SexeServiceLocal;

/**
 * @author steph18
 */
@Transactional
@RequestScoped
public class SexeService extends GenericServiceLocalImpl<Sexe, Integer> implements SexeServiceLocal {

    @Inject
    private SexeDao dao;

    @Override
    protected RepositoryDao<Sexe, Integer> getDAO() {
        return dao;
    }

}
