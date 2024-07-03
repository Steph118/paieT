/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Entite;
import jakarta.ejb.Stateless;

/**
 * @author steph18
 */
@Stateless
public class EntiteDao extends RepositoryDao<Entite, Integer> {

    public EntiteDao() {
        super(Entite.class);
    }

}
