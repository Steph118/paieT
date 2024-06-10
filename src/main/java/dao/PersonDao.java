/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Person;

/**
 *
 * @author steph18
 */
public class PersonDao extends RepositoryDao<Person, Integer> {

    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }

    @Override
    public Integer getId(Person entity) {
        return entity.getId();
    }

}
