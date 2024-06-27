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

/**
 *
 * @author steph18
 * @param <E>
 * @param <ID>
 */
public class RepositoryDao<E extends Serializable, ID> {

    @PersistenceContext
    protected EntityManager em;

    private final Class<E> entityClass;

    public RepositoryDao(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public void save(E entity) {
        this.em.persist(entity);
    }

    public E update(E entity) {
        return this.em.merge(entity);
    }

    public boolean isUpdate(E entity) {
        return this.em.merge(entity) != null;
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

    public Long count() {
        String jpql = "SELECT COUNT(e) FROM " + this.entityClass.getSimpleName() + " e";
        Query query = this.em.createQuery(jpql);
        return (Long) query.getSingleResult();
    }

}
