/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.*;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.math.BigDecimal;
import service.interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.omnifaces.util.Messages;
import utils.AppUtilsBeans;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class SumPaidBean extends GenericBean<SumPaid, Integer> {

    @EJB
    private SumPaidServiceLocal sumPaidService;
    @EJB
    private SumPromisedServiceLocal sumPromisedService;
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
    @EJB
    private MonthServiceLocal monthService;

    @Inject
    private AppUtilsBeans appUtilsBeans;

    private Eglise eglise;
    private Department dptment;
    private Year year;
    private Member member;
    private Loan loan;
    private SumPromised sumPromised;
    private MonthEntity month;
    private Payment payment;
    private BigDecimal diff;

    private List<Eglise> eglises = new ArrayList<>();
    private List<Year> years = new ArrayList<>();
    private List<Member> membres = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();
    private List<MonthEntity> months = new ArrayList<>();

    @Override
    public GenericServiceLocal<SumPaid, Integer> getService() {
        return this.sumPaidService;
    }

    @Override
    public void initAdd() {
        this.entity = new SumPaid();
        this.payment = new Payment();
        this.eglises = this.egliseService.getAll();
        this.departments = this.departmentService.getAll();
        this.years = this.yearService.getAll();
    }

    public void loadMembers() {
        this.member = null;
        if (Objects.nonNull(this.eglise) && Objects.nonNull(this.dptment)) {
            this.membres = this.memberService.getByEgliseAndDptmnt(this.eglise, this.dptment);
        }
        this.loadSumPromised();
    }

    public void loadLoansAndMembers() {
        this.member = null;
        this.loan = null;
        if (Objects.nonNull(this.eglise)) {
            this.loans = this.loanService.getLoansByEglise(this.eglise);
        }
        this.loadMembers();
    }

    public void loadSumPromised() {
        this.sumPromised = null;
        this.entity = new SumPaid();
        if (Objects.nonNull(this.member) && Objects.nonNull(this.loan)
                && Objects.nonNull(this.year)) {
            this.sumPromised = this.sumPromisedService.findBy(this.member, this.loan, this.year);
        }

        if (this.sumPromised != null) {
            this.months = this.monthService.findMontNotPaid(this.sumPromised);
        }
    }

    public void loadSumPaid() {
        this.entity = new SumPaid();
        if (Objects.nonNull(this.member) && Objects.nonNull(this.sumPromised)
                && Objects.nonNull(this.month)) {
            this.entity = this.sumPaidService.findSumPaidBy(this.month, this.sumPromised, this.member);
            System.err.println("entity : " + this.entity);
        }
        if (Objects.isNull(this.entity)) {
            this.entity = new SumPaid(this.month, this.sumPromised, this.member);
            this.diff = this.sumPromised.getMontant();
            System.err.println("entity : " + this.entity);
        } else {
            this.checkSum();
        }
    }

    private void checkSum() {
        BigDecimal sum = this.sumPaidService.totalSumPaid(this.getEntity());
        System.err.println("sum : " + sum);
        if (Objects.nonNull(sum)) {
            diff = this.sumPromised.getMontant().subtract(sum);
            if (diff.doubleValue() > 0) {
                Messages.addFlashGlobalInfo("Il vous reste " + this.appUtilsBeans.numberFormat(diff) + " de paiement");
            } else {
                Messages.addFlashGlobalInfo("Vous ne pouvez plus faire de paiement pour ce mois");
            }

        }
    }

    @Override
    public void beforeSave() {
        boolean b = this.entity.totalSumPaid()
                .subtract(diff).doubleValue() == 0;

    }

    public void addToList() {
        this.entity.addPayment(this.payment);
        this.payment = new Payment();
    }

    public void removeFromList(Payment payment) {
        this.entity.removePayment(payment);
    }

//    public void editFromList(Payment payment) {
//        this.payment = payment;
//        this.entity.removePayment(payment);
//    }
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

    public List<Year> getYears() {
        return years;
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

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public SumPromised getSumPromised() {
        return sumPromised;
    }

    public void setSumPromised(SumPromised sumPromised) {
        this.sumPromised = sumPromised;
    }

    public List<MonthEntity> getMonths() {
        return months;
    }

    public MonthEntity getMonth() {
        return month;
    }

    public void setMonth(MonthEntity month) {
        this.month = month;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
