/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Variable;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

import java.util.Optional;

/**
 * @author steph18
 */
@Transactional
public class VariableDao extends RepositoryDao<Variable, Long> {

    public VariableDao() {
        super(Variable.class);
    }

    public Optional<Variable> findByKey(String key) {
        String jpql = """
                                SELECT v
                                FROM VariablePaid v
                                WHERE v.key = :key
                """;
        try {
            Variable v = this.em.createQuery(jpql, Variable.class)
                    .setParameter("key", key)
                    .getSingleResult();
            return Optional.ofNullable(v);
        } catch (NoResultException e) {
            return Optional.empty();
        }

    }

}
