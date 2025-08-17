/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.Variable;

import java.util.Optional;

/**
 * @author steph18
 */
public interface VariableServiceLocal extends GenericServiceLocal<Variable, Long> {

    Optional<Variable> findByKey(String key);
}
