/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.Country;
import entities.Locality;
import entities.TypeLocality;
import jakarta.ejb.Local;
import java.util.List;

/**
 * @author steph18
 */
@Local
public interface LocalityServiceLocal extends GenericServiceLocal<Locality, Integer> {

    List<Locality> getAll(Country country, TypeLocality localityTypeId);
}