/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Locality;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import service.interfaces.GenericServiceLocal;
import service.interfaces.LocalityServiceLocal;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class LocalityBean extends GenericBean<Locality, Integer> {

    @EJB
    private LocalityServiceLocal localityService;

    @Override
    public GenericServiceLocal<Locality, Integer> getService() {
        return localityService;
    }

    @Override
    public void initAdd() {
        this.entity = new Locality();
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
