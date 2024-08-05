/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Department;
import entities.Eglise;
import entities.Member;
import entities.Person;
import entities.Sexe;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.omnifaces.util.Messages;
import service.interfaces.DepartmentServiceLocal;
import service.interfaces.EgliseServiceLocal;
import service.interfaces.GenericServiceLocal;
import service.interfaces.MemberServiceLocal;
import service.interfaces.PersonServiceLocal;
import service.interfaces.SexeServiceLocal;

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

    private Sexe sexe;
    private Department department;

    private List<Person> persons = new ArrayList<>();
    private List<Sexe> sexes = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private List<Eglise> eglises = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    @Override
    public GenericServiceLocal<Member, Integer> getService() {
        return memberService;
    }

    @Override
    public void initEntity() {
        super.initEntity();
        this.eglises = this.egliseService.getAll();
        this.departments = this.departmentService.getAll();
        this.sexes = this.sexeService.getAll();
    }

    public void addMemberToList() {
        if (!members.contains(this.entity)) {
            this.members.add(this.entity);
            this.entity = new Member();
            this.department = null;
            this.sexe = null;
        } else {
            Messages.addFlashGlobalError("Cette personne est deja ajoute");
        }
    }

    public void removeMemberToList(Member m) {
        this.members.remove(m);
    }

    public void updateMemberToList(Member m) {
        this.removeMemberToList(m);
        this.entity = m;
    }

    @Override
    public void initAdd() {
        this.entity = new Member();
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

    @Override
    public String save() {
        return super.save();
    }
    
    
    

    public List<Person> listPersons(String query) {
        String queryLowerCase = query.toLowerCase();
        this.persons = personService.getAll(this.entity.getEglise(), this.department, this.sexe)
                .stream().filter(t -> t.getFullName().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
        return this.persons;

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

}
