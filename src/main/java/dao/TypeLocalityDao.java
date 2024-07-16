/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.TypeLocality;
import entities.Year;
import jakarta.ejb.Stateless;

/**
 * @author steph18
 */
@Stateless
public class TypeLocalityDao extends RepositoryDao<TypeLocality, Integer> {

    public TypeLocalityDao() {
        super(TypeLocality.class);
    }

}
