/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Person;
import jakarta.ejb.Stateless;

/**
 * @author steph18
 */
@Stateless
public class PersonDao extends RepositoryDao<Person, Integer> {

    public PersonDao() {
        super(Person.class);
    }

}
