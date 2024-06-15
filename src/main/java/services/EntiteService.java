/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.EntiteDao;
import dao.RepositoryDao;
import entities.Entite;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.EntiteServiceLocal;

/**
 *
 * @author steph18
 */
@Stateless
public class EntiteService extends GenericServiceLocalImpl<Entite, Integer>
implements EntiteServiceLocal {

    @EJB
    private EntiteDao dao;

    @Override
    protected RepositoryDao<Entite, Integer> getDAO() {
        return dao;
    }    

}
