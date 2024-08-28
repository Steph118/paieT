/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entities.SumPromised;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

/**
 *
 * @author steph18
 */
@Repository
public interface SumPromisedRepository extends CrudRepository<SumPromised, Integer> {

}
