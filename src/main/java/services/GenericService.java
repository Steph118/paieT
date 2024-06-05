/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import service.interfaces.GenericServiceLocal;
import jakarta.ejb.Stateless;
import java.io.Serializable;

/**
 *
 * @author steph18
 * @param <E>
 * @param <T>
 */
@Stateless
public class GenericService<E extends Serializable, T> implements GenericServiceLocal{
    
}
