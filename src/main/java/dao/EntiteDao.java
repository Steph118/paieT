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

    @Override
    public Class<Entite> getEntityClass() {
        return Entite.class;
    }

    @Override
    public Integer getId(Entite entite) {
        return entite.getId();
    }
    
}
