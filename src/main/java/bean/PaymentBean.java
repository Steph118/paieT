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
import jakarta.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import service.interfaces.GenericServiceLocal;
import service.interfaces.PaymentServiceLocal;
import service.interfaces.SumPaidServiceLocal;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class PaymentBean extends GenericBean<Payment, Integer> {

    @EJB
    private PaymentServiceLocal paymentService;

    @EJB
    private SumPaidServiceLocal sumPaidService;

    private Eglise eglise;
    private Department dptment;

    private List<Eglise> eglises = new ArrayList<>();
    private List<Year> years = new ArrayList<>();
    private List<Member> membres = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    private SumPaid SumPaid;
    private boolean add;

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
        super.loadEntity();
        this.SumPaid = new SumPaid();
        if (this.entity != null) {
            this.SumPaid = this.sumPaidService.findSumPaidBy(this.entity.getSumPaid().getMonth(),
                    this.entity.getSumPaid().getPromesse(), this.entity.getSumPaid().getMember());

            this.SumPaid.removePayment(this.entity);
        }
    }

    @Override
    public void beforeUpdate() {
        BigDecimal result = this.SumPaid.totalSumPaid().add(this.entity.getAmount())
                .subtract(this.entity.getSumPaid().getSumPromised().getMontant());
        this.add = result.doubleValue() > 0;
    }

    @Override
    public String update() {
        if (!isAdd()) {
            return null;
        }
        return super.update();
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

    public boolean isAdd() {
        return add;
    }

}
