/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Eglise;
import entities.Loan;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import service.interfaces.EgliseServiceLocal;
import service.interfaces.GenericServiceLocal;
import service.interfaces.LoanServiceLocal;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class LoanBean extends GenericBean<Loan, Integer> {

    @EJB
    private LoanServiceLocal loanService;
    @EJB
    private EgliseServiceLocal egliseService;

    private List<Eglise> eglises = new ArrayList<>();

    @Override
    public GenericServiceLocal<Loan, Integer> getService() {
        return loanService;
    }

    @Override
    public void initEntity() {
        super.initEntity();
        this.eglises = this.egliseService.getAll();
    }

    @Override
    public void initAdd() {
        this.entity = new Loan();
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

    public List<Eglise> getEglises() {
        return eglises;
    }

    public void setEglises(List<Eglise> eglises) {
        this.eglises = eglises;
    }
}
