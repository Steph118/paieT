/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.EgliseDao;
import dao.RepositoryDao;
import entities.Eglise;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.EgliseServiceLocal;

/**
 *
 * @author steph18
 */
@Stateless
public class EgliseService extends GenericServiceLocalImpl<Eglise, Integer>
implements EgliseServiceLocal {

    @EJB
    private EgliseDao dao;

    @Override
    protected RepositoryDao<Eglise, Integer> getDAO() {
        return dao;
    }    

}
