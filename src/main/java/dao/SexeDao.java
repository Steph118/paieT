/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Sexe;
import jakarta.ejb.Stateless;

/**
 * @author steph18
 */
@Stateless
public class SexeDao extends RepositoryDao<Sexe, Integer> {

    public SexeDao() {
        super(Sexe.class);
    }

}
