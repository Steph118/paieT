/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Country;
import entities.Locality;
import entities.TypeLocality;
import jakarta.ejb.Stateless;

import java.util.List;

/**
 * @author steph18
 */
@Stateless
public class LocalityDao extends RepositoryDao<Locality, Integer> {

    public LocalityDao() {
        super(Locality.class);
    }

    public List<Locality> getAll(Country country, TypeLocality localityType) {
        String jpql = "SELECT e FROM " + this.getEntityClassName() + " e WHERE e.country.id = :countryId AND e.localityType.id = :localityTypeId";
        return this.em.createQuery(jpql, this.getEntityClass())
                .setParameter("countryId", country.getId())
                .setParameter("localityTypeId", localityType.getId())
                .getResultList();
    }
}
