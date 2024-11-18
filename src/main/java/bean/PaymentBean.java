/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Department;
import entities.Eglise;
import entities.Loan;
import entities.Member;
import entities.Payment;
import entities.SumPaid;
import entities.Year;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.omnifaces.util.Messages;
import service.interfaces.GenericServiceLocal;
import service.interfaces.PaymentServiceLocal;
import utils.AppUtilsBeans;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class PaymentBean extends GenericBean<Payment, Integer> {

    @EJB
    private PaymentServiceLocal paymentService;

    @Inject
    private AppUtilsBeans appUtilsBeans;

    private Eglise eglise;
    private Department dptment;
    private SumPaid SumPaid;
    private boolean notAdd;

    private List<Eglise> eglises = new ArrayList<>();
    private List<Year> years = new ArrayList<>();
    private List<Member> membres = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    @Override
    public void initAdd() {
        this.entity = new Payment();
    }

    @Override
    public boolean canAdd() {
        return true;
    }

    @Override
    public void loadEntity() {
        this.entity = this.getService().findById(this.entityId);
        this.SumPaid = new SumPaid();
        if (this.entity != null) {
            this.SumPaid = this.entity.getSumPaid();
            //this.SumPaid.removePayment(this.entity);
        }
    }

    @Override
    public void beforeUpdate() {
        this.SumPaid.removePayment(this.entity);
        BigDecimal result = this.SumPaid.totalSumPaid().add(this.entity.getAmount())
                .subtract(this.SumPaid.getSumPromised().getMontant());
        this.notAdd = result.doubleValue() > 0;
    }

    @Override
    public String update() {
        if (isNotAdd()) {
            Messages.addFlashGlobalError("La somme de vos paiements dépasse le montant promis");
            return null;
        }
        this.entity.setSumPaid(SumPaid);
        return super.update();
    }

    public String rest() {
        BigDecimal rest = this.SumPaid.getSumPromised().getMontant()
                .subtract(this.SumPaid.totalSumPaid().subtract(this.entity.getAmount()));
        return appUtilsBeans.numberFormat(rest);
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

    @Override
    public GenericServiceLocal<Payment, Integer> getService() {
        return paymentService;
    }

    public List<Eglise> getEglises() {
        return eglises;
    }

    public List<Member> getMembres() {
        return membres;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public List<Year> getYears() {
        return years;
    }

    public Eglise getEglise() {
        return eglise;
    }

    public void setEglise(Eglise eglise) {
        this.eglise = eglise;
    }

    public Department getDptment() {
        return dptment;
    }

    public void setDptment(Department dptment) {
        this.dptment = dptment;
    }

    public void setEglises(List<Eglise> eglises) {
        this.eglises = eglises;
    }

    public void setYears(List<Year> years) {
        this.years = years;
    }

    public void setMembres(List<Member> membres) {
        this.membres = membres;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public SumPaid getSumPaid() {
        return SumPaid;
    }

    public boolean isNotAdd() {
        return notAdd;
    }

}
