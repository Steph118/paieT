/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Department;
import entities.Person;
import entities.Sexe;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import java.util.List;
import java.util.Objects;

/**
 * @author steph18
 */
@Stateless
public class PersonDao extends RepositoryDao<Person, Integer> {

    public PersonDao() {
        super(Person.class);
    }

    public List<Person> getPersonsNotMember(Integer egliseId, Department department, Sexe sexe) {
        String jpql = "SELECT p FROM Person p WHERE p.eglise.id = :egliseId AND p.id NOT IN (SELECT m.person.id FROM Member m)";
        if (Objects.nonNull(department)) {
            jpql += " AND p.department.id = :departmentId ";
        }
        if (Objects.nonNull(sexe)) {
            jpql += " AND p.sexe.id = :sexeId ";
        }
        Query q = this.em.createQuery(jpql);
        q.setParameter("egliseId", egliseId);
        if (Objects.nonNull(department)) {
            q.setParameter("departmentId", department.getId());
        }
        if (Objects.nonNull(sexe)) {
            q.setParameter("sexeId", sexe.getId());
        }
        return q.getResultList();
    }

}
