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
import java.util.Optional;
import java.util.logging.Logger;

/**
 * @param <E>
 * @param <ID>
 * @author steph18
 */
public class RepositoryDao<E extends Serializable, ID> {

    protected final Logger logger;
    private final Class<E> entityClass;
    
    @PersistenceContext
    protected EntityManager em;

    public RepositoryDao(Class<E> entityClass) {
        this.entityClass = entityClass;
        this.logger = Logger.getLogger(this.entityClass.getName());
    }

    public void save(E e) {
        this.em.persist(e);
    }

    public E update(E e) {
        return this.em.merge(e);
    }

    public boolean isUpdate(E e) {
        return this.em.merge(e) != null;
    }

    public void delete(ID id) {
        this.em.remove(this.findById(id));
    }

    public void delete(E e) {
        this.em.remove(this.em.merge(e));
    }

    public void deleteAll() {
        String jpql = "DELETE FROM " + this.entityClass.getSimpleName();
        Query query = this.em.createQuery(jpql);
        query.executeUpdate();
    }

    public E findById(ID id) {
        return this.em.find(this.entityClass, id);
    }

    public boolean exists(ID id) {
        return this.findById(id) != null;
    }

    public E getReference(ID id) {
        return this.em.getReference(this.entityClass, id);
    }

    public Optional<E> FindByIdOpt(ID id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(this.em.find(this.entityClass, id));
    }

    public List<E> getAll() {
        String jpql = "SELECT e FROM " + this.entityClass.getSimpleName() + " e";
        Query query = this.em.createQuery(jpql);
        return query.getResultList();
    }

    public List<E> getAll2() {
        return this.em.createQuery(
                        "FROM " + this.entityClass.getSimpleName() + " e ", this.entityClass)
                .getResultList();
    }

    public Long count() {
        String jpql = "SELECT COUNT(e) FROM " + this.entityClass.getSimpleName() + " e";
        Query query = this.em.createQuery(jpql);
        return (Long) query.getSingleResult();
    }
}
