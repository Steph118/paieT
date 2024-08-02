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

    @Override
    public GenericServiceLocal<Member, Integer> getService() {
        return memberService;
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

    public List<Eglise> listEglises() {
        return this.egliseService.getAll();
    }

    public List<Department> listDepartments() {
        return this.departmentService.getAll();
    }

    public List<Sexe> listSexes() {
        return this.sexeService.getAll();
    }

    public List<Person> listPersons() {
        return personService.getAll(this.entity.getEglise(), this.department, this.sexe);
    }

    public List<Person> listPersons2(String query) {
        String queryLowerCase = query.toLowerCase();
        return personService.getAll(this.entity.getEglise(), this.department, this.sexe)
                .stream().filter(t -> t.getFullName().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());

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

}
