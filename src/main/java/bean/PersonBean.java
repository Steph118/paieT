/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Person;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import service.interfaces.GenericServiceLocal;
import service.interfaces.PersonServiceLocal;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class PersonBean extends GenericBean<Person, Integer> {

    @EJB
    private PersonServiceLocal personService;

    @Override
    public GenericServiceLocal<Person, Integer> getService() {
        return personService;
    }

    @Override
    public void initAdd() {
        this.entity = new Person();
    }

    @Override
    public boolean canAdd() {
        return true;
    }

    @Override
    public boolean canDelete() {
        return true;
    }

    @Override
    public boolean canDetails() {
        return true;
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

}
