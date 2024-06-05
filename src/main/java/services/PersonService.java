/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.PersonDao;
import entities.Person;
import jakarta.ejb.EJB;
import service.interfaces.PersonServiceLocal;

/**
 *
 * @author steph18
 */
public class PersonService extends GenericService<Person,Long> implements PersonServiceLocal{
    
    @EJB
    private  PersonDao dao;  
}
