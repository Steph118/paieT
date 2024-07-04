/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import dao.SexeDao;
import entities.Sexe;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.SexeServiceLocal;
import service.interfaces.YearServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class SexeService extends GenericServiceLocalImpl<Sexe, Integer> implements SexeServiceLocal {

    @EJB
    private SexeDao dao;

    @Override
    protected RepositoryDao<Sexe, Integer> getDAO() {
        return dao;
    }

}
