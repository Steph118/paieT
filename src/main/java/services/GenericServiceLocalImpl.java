/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import service.interfaces.GenericServiceLocal;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * @param <E>
 * @param <ID>
 * @author steph18
 */
public abstract class GenericServiceLocalImpl<E extends Serializable, ID>
        implements GenericServiceLocal<E, ID> {

    /**
     *
     */
    protected final Logger LOGGER;

    public GenericServiceLocalImpl() {
        this.LOGGER = Logger.getLogger(this.getClass().getName());
    }

    protected abstract RepositoryDao<E, ID> getDAO();

    @Override
    public void save(E e) {
        this.getDAO().save(e);
    }

    @Override
    public E findById(ID id) {
        return this.getDAO().findById(id);
    }

    @Override
    public void delete(E e) {
        this.getDAO().delete(e);
    }

    @Override
    public int delete(ID id) {
        return this.getDAO().delete(id);
    }

    @Override
    public Long count() {
        return this.getDAO().count();
    }

    @Override
    public List<E> getAll() {
        return this.getDAO().getAll();
    }

    @Override
    public Optional<E> FindByIdOpt(ID id) {
        return this.getDAO().FindByIdOpt(id);
    }

    @Override
    public E getReference(ID id) {
        return this.getDAO().getReference(id);
    }

    @Override
    public boolean exists(ID id) {
        return this.getDAO().exists(id);
    }

    @Override
    public int deleteAll() {
        return this.getDAO().deleteAll();
    }

    @Override
    public boolean isUpdate(E e) {
        return this.getDAO().isUpdate(e);
    }

    @Override
    public E update(E e) {
        return this.getDAO().update(e);
    }

    @Override
    public void saveAll(List<E> es) {
        es.forEach(this::save);
    }

    @Override
    public void updateAll(List<E> es) {
        es.forEach(this::update);
    }

    @Override
    public void deleteAll(List<E> es) {
        es.forEach(this::delete);
    }

}
