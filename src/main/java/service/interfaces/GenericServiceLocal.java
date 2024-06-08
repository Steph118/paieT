/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import java.io.Serializable;

/**
 *
 * @author steph18
 * @param <E>
 * @param <ID>
 */
public interface GenericServiceLocal<E extends Serializable, ID> {

    void save(E e);

    void delete(E e);

    E find(E e);

    E findById(ID id);

    void delete(ID id);
}
