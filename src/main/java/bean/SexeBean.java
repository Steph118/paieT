/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Sexe;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import service.interfaces.GenericServiceLocal;
import service.interfaces.SexeServiceLocal;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class SexeBean extends GenericBean<Sexe, Integer> {

    @EJB
    private SexeServiceLocal sexeService;

    @Override
    public GenericServiceLocal<Sexe, Integer> getService() {
        return sexeService;
    }

    @Override
    public void initAdd() {
        this.entity = new Sexe();
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
