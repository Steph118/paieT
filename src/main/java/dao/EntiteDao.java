/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Entite;

/**
 *
 * @author steph18
 */
public class EntiteDao extends RepositoryDao<Entite, Integer> {
    
    public EntiteDao(Class<Entite> entityClass) {
        super(entityClass);
    }
    
}
