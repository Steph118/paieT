/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.ContributorDao;
import dao.RepositoryDao;
import entities.Contributor;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.ContributorServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class ContributorService extends GenericServiceLocalImpl<Contributor, Integer>
        implements ContributorServiceLocal {

    @EJB
    private ContributorDao dao;

    @Override
    protected RepositoryDao<Contributor, Integer> getDAO() {
        return dao;
    }

}
