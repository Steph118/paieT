/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Payment;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import service.interfaces.GenericServiceLocal;
import service.interfaces.PaymentServiceLocal;


/**
 * @author steph18
 */
@Named
@ViewScoped
public class PaymentBean extends GenericBean<Payment, Integer> {

    @EJB
    private PaymentServiceLocal paymentService;

    

    @Override
    public void initAdd() {
        this.entity = new Payment();
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

    @Override
    public GenericServiceLocal<Payment, Integer> getService() {
        return paymentService;
    }

}
