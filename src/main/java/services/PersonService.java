/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.PersonDao;
import dao.RepositoryDao;
import entities.Department;
import entities.Eglise;
import entities.Member;
import entities.Person;
import entities.Sexe;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import service.interfaces.MemberServiceLocal;
import service.interfaces.PersonServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class PersonService extends GenericServiceLocalImpl<Person, Integer>
        implements PersonServiceLocal {

    @EJB
    private PersonDao dao;

    @EJB
    private MemberServiceLocal memberService;

    @Override
    protected RepositoryDao<Person, Integer> getDAO() {
        return dao;
    }

    @Override
    public List<Person> getPersonsNotMember(Eglise eglise, Department departement, Sexe sexe) {
        if (Objects.nonNull(eglise)) {
            return this.dao.getPersonsNotMember(eglise.getId(), departement, sexe);
        }
        return new ArrayList<>();
    }

    @Override
    public List<Person> getPersons(Eglise eglise, Department departement, Sexe sexe) {
        if (Objects.nonNull(eglise)) {
            return this.dao.getPersons(eglise.getId(), departement, sexe);
        }
        return new ArrayList<>();
    }

    @Override
    public Person update(Person e) {
        return super.update(e);
    }

    @Override
    public Person update2(Person p) {
        Person p1 = this.update(p);
        if (p1 != null) {
            Eglise e = p1.getEglise();
            int i = this.memberService.genererNumeroMembre(e);
            this.memberService.updateEglise(p, i);
        }
        return p1;
    }

}
