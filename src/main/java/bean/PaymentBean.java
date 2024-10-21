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
import entities.Year;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import service.interfaces.DepartmentServiceLocal;
import service.interfaces.EgliseServiceLocal;
import service.interfaces.GenericServiceLocal;
import service.interfaces.LoanServiceLocal;
import service.interfaces.MemberServiceLocal;
import service.interfaces.PaymentServiceLocal;
import service.interfaces.YearServiceLocal;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class PaymentBean extends GenericBean<Payment, Integer> {

    @EJB
    private PaymentServiceLocal paymentService;
    @EJB
    private EgliseServiceLocal egliseService;
    @EJB
    private DepartmentServiceLocal departmentService;
    @EJB
    private YearServiceLocal yearService;
    @EJB
    private LoanServiceLocal loanService;
    @EJB
    private MemberServiceLocal memberService;

    private Eglise eglise;
    private Department dptment;

    private List<Eglise> eglises = new ArrayList<>();
    private List<Year> years = new ArrayList<>();
    private List<Member> membres = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    @Override
    public void initAdd() {
        this.entity = new Payment();
        this.eglises = this.egliseService.getAll();
        this.departments = this.departmentService.getAll();
        this.years = this.yearService.getAll();
    }

    public void loadMembers() {
        if (Objects.nonNull(this.eglise) && Objects.nonNull(this.dptment)) {
            this.membres = this.memberService.getByEgliseAndDptmnt(this.eglise, this.dptment);
            System.err.println("in loadMembers");
            System.err.println("Members values" + loans);
        }
    }

    public void loadLoansAndMembers() {
        if (Objects.nonNull(this.eglise)) {
            this.loans = this.loanService.getLoansByEglise(this.eglise);
            System.err.println("in loadLoansAndMembers");
            System.err.println("in loadLoansAndMembers values" + loans);
        }
        this.loadMembers();
    }

    @Override
    public boolean canAdd() {
        return true;
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

}
