/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Eglise;

/**
 *
 * @author steph18
 */
public class EgliseDao extends RepositoryDao<Eglise, Integer> {

    @Override
    public Class<Eglise> getEntityClass() {
        return Eglise.class;
    }

    @Override
    public Integer getId(Eglise eglise) {
        return eglise.getId();
    }
    
}
