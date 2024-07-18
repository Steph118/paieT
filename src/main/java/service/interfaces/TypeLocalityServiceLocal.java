/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.TypeLocality;
import jakarta.ejb.Local;
import java.util.List;

/**
 * @author steph18
 */
@Local
public interface TypeLocalityServiceLocal extends GenericServiceLocal<TypeLocality, Integer> {

    List<TypeLocality> getAll(Integer id);

    List<TypeLocality> getBrothers(TypeLocality parent);

    List<TypeLocality> getAscendants(TypeLocality typeLocality);

    List<TypeLocality> getAscendantsAndBrothers(TypeLocality typeLocality);

    List<TypeLocality> getOthersRoots(TypeLocality typeLocality);

    List<TypeLocality> getRoots();

    List<TypeLocality> getAppropriateTypesLoclity(TypeLocality entity, Integer entityId);
}
