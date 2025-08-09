/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Role;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

import java.util.logging.Level;

/**
 * @author steph18
 */
@Transactional
public class RoleDao extends RepositoryDao<Role, Integer> {

    public RoleDao() {
        super(Role.class);
    }

    @Override
    public Role findById(Integer id) {
        System.err.println("find by id --- find by id");
        try {
            return this.em.createQuery("""
                                            SELECT r FROM Role r
                                            LEFT JOIN FETCH r.permissions
                                            WHERE r.id = :id
                                            """,
                    Role.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            LOGGER.log(Level.SEVERE, "No role found with id {0}", id);
            LOGGER.log(Level.SEVERE, "NoResultException: ", e);
            return null;
        }
    }
}
