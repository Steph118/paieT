/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.CountryDao;
import dao.PaymentDao;
import dao.RepositoryDao;
import entities.Country;
import entities.Payment;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.PaymentServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class PaymentService extends GenericServiceLocalImpl<Payment, Integer> implements PaymentServiceLocal {

    @EJB
    private PaymentDao dao;

    @Override
    protected RepositoryDao<Payment, Integer> getDAO() {
        return dao;
    }
}
