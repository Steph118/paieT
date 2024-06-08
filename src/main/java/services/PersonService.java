/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.PersonDao;
import dao.RepositoryDao;
import entities.Person;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.PersonServiceLocal;

/**
 *
 * @author steph18
 */
@Stateless
public class PersonService extends GenericServiceLocalImpl<Person, Long> 
implements PersonServiceLocal{

    @EJB
    private PersonDao dao;

    @Override
    protected RepositoryDao<Person, Long> getDAO() {
        return dao;
    }    

}
