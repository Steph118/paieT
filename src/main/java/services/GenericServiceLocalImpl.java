/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import service.interfaces.GenericServiceLocal;
import java.io.Serializable;

/**
 *
 * @author steph18
 * @param <E>
 * @param <ID>
 */
public abstract class GenericServiceLocalImpl<E extends Serializable, ID>
        implements GenericServiceLocal<E, ID> {

    protected abstract RepositoryDao<E, ID> getDAO();

    @Override
    public void save(E e) {
        getDAO().save(e);
    }

    @Override
    public E findById(ID id) {
        return getDAO().findById(id);
    }

    @Override
    public E find(E e) {
        return getDAO().find(e);
    }

    @Override
    public void delete(E e) {

    }

    @Override
    public void delete(ID id) {
        getDAO().delete(id);
    }

}
