/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.SumPromised;
import entities.Year;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import service.interfaces.GenericServiceLocal;
import service.interfaces.YearServiceLocal;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class SumPromisedBean extends GenericBean<SumPromised, Integer> {

    @EJB
    private Sum yearService;

    @Override
    public GenericServiceLocal<Year, Integer> getService() {
        return yearService;
    }

    @Override
    public void initAdd() {
        this.entity = new Year();
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
