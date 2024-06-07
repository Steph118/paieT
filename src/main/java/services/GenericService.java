/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import service.interfaces.GenericServiceLocal;
import jakarta.ejb.Stateless;
import java.io.Serializable;

/**
 *
 * @author steph18
 * @param <E>
 * @param <ID>
 */
public abstract class GenericService<E extends Serializable, ID> implements GenericServiceLocal {

    protected abstract RepositoryDao<E, ID> getDAO();

}
