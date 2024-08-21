/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.Department;
import entities.Eglise;
import entities.Person;
import entities.Sexe;
import jakarta.ejb.Local;
import java.util.List;

/**
 * @author steph18
 */
@Local
public interface PersonServiceLocal extends GenericServiceLocal<Person, Integer> {

    List<Person> getPersonsNotMember(Eglise eglise, Department departement, Sexe sexe);

    List<Person> getPersons(Eglise eglise, Department departement, Sexe sexe);
}
