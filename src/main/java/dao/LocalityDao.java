/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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

    public List<Locality> getAll(Integer countryId,Integer localityTypeId){
         String jpql = "SELECT e FROM " + Locality.class.getSimpleName() + " e WHERE e.country.id = :countryId AND e.localityType.id = :localityTypeId";
        return this.em.createQuery(jpql)
                .setParameter("countryId", countryId)
                .setParameter("localityTypeId", localityTypeId)
                .getResultList();
    }
}
