/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @param <E>
 * @param <ID>
 * @author steph18
 */
public interface GenericServiceLocal<E extends Serializable, ID> {

    void save(E e);

    E update(E e);

    boolean isUpdate(E e);

    void delete(E e);

    void delete(ID id);

    void deleteAll();

    E findById(ID id);

    boolean exists(ID id);

    E getReference(ID id);

    Optional<E> FindByIdOpt(ID id);

    List<E> getAll();

    Long count();

}