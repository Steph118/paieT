/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author steph18
 * @param <E>
 * @param <ID>
 */
public abstract class RepositoryDao<E extends Serializable, ID> {

    @PersistenceContext
    protected EntityManager em;

    public abstract Class<E> getEntityClass();

    public abstract ID getId(E entity);

    public void save(E entity) {
        this.em.persist(entity);
    }

    public void update(E entity) {
        this.em.merge(entity);
    }

    public void delete(ID id) {
        this.em.remove(this.findById(id));
    }

    public E findById(ID id) {
        return this.em.find(this.getEntityClass(), id);
    }

    public E find(E e) {
        String query = "SELECT e FROM " + getEntityClass() + " WHERE e.id  :id";
        Query q = this.em.createQuery(query);
        return e;
    }

    public List<E> findAll() {
        String query = "SELECT e FROM " + getEntityClass() + " e ";
        return this.em.createQuery(query).getResultList();
        
    }
}
