/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;

/**
 *
 * @author steph18
 * @param <E>
 * @param <ID>
 */
@Stateless
public class GenericDao<E extends Serializable, ID> implements RepositoryDao{
    
    @PersistenceContext
    protected EntityManager em;
    
}
