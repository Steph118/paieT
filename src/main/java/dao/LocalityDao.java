/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Locality;
import entities.Year;
import jakarta.ejb.Stateless;

/**
 * @author steph18
 */
@Stateless
public class LocalityDao extends RepositoryDao<Locality, Integer> {

    public LocalityDao() {
        super(Locality.class);
    }

}
