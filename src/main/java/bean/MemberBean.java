/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Department;
import entities.Eglise;
import entities.Loan;
import entities.Member;
import entities.Person;
import entities.Sexe;
import entities.SumPromised;
import entities.Year;
import exception.BusinessException;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.stream.Collectors;
import org.omnifaces.util.Messages;
import service.interfaces.DepartmentServiceLocal;
import service.interfaces.EgliseServiceLocal;
import service.interfaces.GenericServiceLocal;
import service.interfaces.LoanServiceLocal;
import service.interfaces.MemberServiceLocal;
import service.interfaces.PersonServiceLocal;
import service.interfaces.SexeServiceLocal;
import service.interfaces.YearServiceLocal;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class MemberBean extends GenericBean<Member, Integer> {

    @EJB
    private MemberServiceLocal memberService;
    @EJB
    private PersonServiceLocal personService;
    @EJB
    private EgliseServiceLocal egliseService;
    @EJB
    private DepartmentServiceLocal departmentService;
    @EJB
    private SexeServiceLocal sexeService;
    @EJB
    private LoanServiceLocal loanService;
    @EJB
    private YearServiceLocal yearService;

    private Sexe sexe;
    private Department department;
    private boolean updateIntoList;
    private boolean customizeNumMember;
    private int previousMemberId;
    private SumPromised sumPromised;

    private List<Person> persons = new ArrayList<>();
    private List<Sexe> sexes = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private List<Eglise> eglises = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();
    private List<Year> years = new ArrayList<>();
    private List<SumPromised> sums = new ArrayList<>();

    private boolean addManyMember = true;

    @Override
    public GenericServiceLocal<Member, Integer> getService() {
        return memberService;
    }

    @Override
    public void beforeSave() {
        if (!this.addManyMember) {
        }
    }

    @Override
    public void initEntity() {
        super.initEntity();
        this.eglises = this.egliseService.getAll();
        this.departments = this.departmentService.getAll();
        this.sexes = this.sexeService.getAll();
    }

    public void initSumPromised() {
        if (!addManyMember) {
            this.sumPromised = new SumPromised();
            this.years = yearService.getAll();
            this.loadLoan();
        }
    }

    private void loadLoan() {
        if (Objects.nonNull(this.entity.getEglise())) {
            this.loans = loanService.getLoansByEglise(this.entity.getEglise());
        }
    }

    @Override
    public void initAdd() {
        this.entity = new Member();
    }

    @Override
    public void loadEntity() {
        super.loadEntity();
        this.listPersons();
        this.previousMemberId = this.entity.getEglise().getId();
    }

    public void addMemberToList() {
        this.updateIntoList = false;
        if (!members.contains(this.entity)) {
            this.members.add(this.entity);
            Eglise e = this.entity.getEglise();
            this.entity = new Member();
            this.department = null;
            this.sexe = null;
            this.entity.setEglise(e);
        } else {
            Messages.addFlashGlobalError("Cette personne est déjà ajoutée dans la liste de membres");
        }
    }

    public void removeMemberToList(Member m) {
        this.members.remove(m);
    }

    public void updateMemberToList(Member m) {
        this.entity = m;
        this.removeMemberToList(m);
        this.updateIntoList = true;
        this.listPersons();
    }

    public List<Person> listPersons(String query) {
        String queryLowerCase = query.toLowerCase();
        this.entity.setPerson(null);
        this.persons = personService.getPersonsNotMember(this.entity.getEglise(), this.department, this.sexe)
                .stream().filter(t -> t.getFullName().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
        return this.persons;

    }

    public void listPersons() {
        this.persons = this.personService.getPersonsNotMember(this.entity.getEglise(), this.department, this.sexe);
        if (!addManyMember) {
            this.loadLoan();
        }
    }

    @Override
    public String save() {
        try {
            logger.log(Level.INFO, "MemberBean Save...");
            this.memberService.saveAll(this.members);
            Messages.addFlashGlobalInfo("Ajout effectué avec succès.");
            this.logger.info("Enregistrement effectué");
            return cancel();
        } catch (BusinessException ex) {
            Messages.addGlobalError(ex.getMessage());
            this.logger.log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        } catch (Exception ex) {
            Messages.addGlobalError("Une erreur est survenue lors de l'ajout.");
            this.logger.log(Level.SEVERE, ex, () -> "Erreur à l'ajout de l'objet");
            return null;
        }

    }

    public void toCustomizeNumMember() {
        customizeNumMember = !customizeNumMember;
        this.members = new ArrayList<>();
    }

    @Override
    public void beforeUpdate() {
        if (!(this.entity.getEglise().getId() == previousMemberId)) {
            this.entity.setMemberNumber(this.memberService.genererNumeroMembre(this.entity));
        }
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
        return false;
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    public boolean isUpdateIntoList() {
        return updateIntoList;
    }

    public void setUpdateIntoList(boolean updateIntoList) {
        this.updateIntoList = updateIntoList;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<Sexe> getSexes() {
        return sexes;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Eglise> getEglises() {
        return eglises;
    }

    public List<Member> getMembers() {
        return members;
    }

    public boolean isCustomizeNumMember() {
        return customizeNumMember;
    }

    public void setCustomizeNumMember(boolean customizeNumMember) {
        this.customizeNumMember = customizeNumMember;
    }

    public boolean isAddManyMember() {
        return addManyMember;
    }

    public void setAddManyMember(boolean addManyMember) {
        this.addManyMember = addManyMember;
    }

    public SumPromised getSumPromised() {
        return sumPromised;
    }

    public void setSumPromised(SumPromised sumPromised) {
        this.sumPromised = sumPromised;
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

    public List<SumPromised> getSums() {
        return sums;
    }

    public void setSums(List<SumPromised> sums) {
        this.sums = sums;
    }

}
