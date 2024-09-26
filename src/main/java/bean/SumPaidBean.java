/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.SumPaid;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import service.interfaces.GenericServiceLocal;
import service.interfaces.SumPaidServiceLocal;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class SumPaidBean extends GenericBean<SumPaid, Integer> {

    @EJB
    private SumPaidServiceLocal sumPaidService;

    @Override
    public GenericServiceLocal<SumPaid, Integer> getService() {
        return sumPaidService;
    }

    @Override
    public void initAdd() {
        this.entity = new SumPaid();
    }

    @Override
    public boolean canAdd() {
        return false;
    }

    @Override
    public boolean canDelete() {
        return false;
    }

    @Override
    public boolean canDetails() {
        return true;
    }

    @Override
    public boolean canUpdate() {
        return false;
    }

}
