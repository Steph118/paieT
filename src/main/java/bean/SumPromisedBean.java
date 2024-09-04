/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Department;
import entities.Eglise;
import entities.Loan;
import entities.Member;
import entities.SumPromised;
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
import service.interfaces.SumPromisedServiceLocal;
import service.interfaces.YearServiceLocal;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class SumPromisedBean extends GenericBean<SumPromised, Integer> {

    @EJB
    private SumPromisedServiceLocal sumPromisedService;
    @EJB
    private DepartmentServiceLocal departmentService;
    @EJB
    private EgliseServiceLocal egliseService;
    @EJB
    private MemberServiceLocal memberService;
    @EJB
    private YearServiceLocal yearService;
    @EJB
    private LoanServiceLocal loanService;

    private Eglise eglise;
    private Department dptment;

    private List<Eglise> eglises = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();
    private List<Year> years = new ArrayList<>();

    @Override
    public GenericServiceLocal<SumPromised, Integer> getService() {
        return sumPromisedService;
    }

    @Override
    public void initAdd() {
        this.entity = new SumPromised();
    }

    @Override
    public void initEntity() {
        super.initEntity();
        this.dptment = new Department();
        this.eglise = new Eglise();
        this.years = this.yearService.getAll();
        this.departments = this.departmentService.getAll();
        this.eglises = this.egliseService.getAll();
    }

    public void loadMembers() {
        if (Objects.nonNull(this.eglise) && Objects.nonNull(this.dptment)) {
            this.members = this.memberService.getByEgliseAndDptmnt(this.eglise, this.dptment);
        }
    }

    public void loadLoansAndMembers() {
        if (Objects.nonNull(this.eglise)) {
            this.loans = this.loanService.getLoansByEglise(this.eglise);
        }
        this.loadMembers();
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

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
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

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public List<Year> getYears() {
        return years;
    }

    public void setYears(List<Year> years) {
        this.years = years;
    }

}
