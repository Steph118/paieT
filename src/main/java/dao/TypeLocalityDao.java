/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.TypeLocality;
import jakarta.ejb.Stateless;

import java.util.List;

/**
 * @author steph18
 */
@Stateless
public class TypeLocalityDao extends RepositoryDao<TypeLocality, Integer> {

    public TypeLocalityDao() {
        super(TypeLocality.class);
    }

    public List<TypeLocality> getAll(Integer id) {
        String jpql = "SELECT e FROM " + TypeLocality.class.getSimpleName() + " e where e.id != :id";
        return this.em.createQuery(jpql)
                .setParameter("id", id).getResultList();
    }

    public List<TypeLocality> getBrothers(Integer id, Integer idParent) {
        String jpql = "SELECT e FROM " + TypeLocality.class.getSimpleName() + " e where e.id != :id and e.typeLocalityParent.id = :idParent";
        return this.em.createQuery(jpql)
                .setParameter("id", id)
                .setParameter("idParent", idParent)
                .getResultList();
    }

    public List<TypeLocality> getRoots() {
        String jpql = "SELECT e FROM " + TypeLocality.class.getSimpleName() + " e where e.root = :root";
        return this.em.createQuery(jpql)
                .setParameter("root", true)
                .getResultList();
    }

    public List<TypeLocality> getOthersRoots(Integer id) {
        String jpql = "SELECT e FROM " + TypeLocality.class.getSimpleName() + " e where e.root = :root and e.id != :id";
        return this.em.createQuery(jpql)
                .setParameter("root", true)
                .setParameter("id", id)
                .getResultList();
    }

    /*@Override
    public TypeLocality findById(Integer id) {
        String jpql = "SELECT e FROM " + TypeLocality.class.getSimpleName() + " e LEFT JOIN FETCH e.typeLocalityParent WHERE e.id = :id";
        return this.em.createQuery(jpql, TypeLocality.class)
                .setParameter("id", id)
                .getSingleResult();
    }*/

}
