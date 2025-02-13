/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.User;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * @author steph18
 */
@Transactional
public class UserDao extends RepositoryDao<User, Integer> {

    public UserDao() {
        super(User.class);
    }

    public Set<String> findRolesForUser(User user) {
        String jpql = "SELECT r.label FROM Role r JOIN r.users u WHERE u.id = :id ";
        Query query = this.em.createQuery(jpql, String.class)
                .setParameter("id", user.getId());
        //return query.getResultList().isEmpty() ? new HashSet<>() : new HashSet<String>(query.getResultList());
        return new HashSet<>(query.getResultList());
    }

    public User findByUsername(String username) {
        String jpql = "SELECT u FROM User u WHERE u.username = :username ";
        try {
            return this.em.createQuery(jpql, User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean hasPermission(String username, String resource, String action) {
        TypedQuery<Long> query = em.createQuery("""
                        SELECT COUNT(p) FROM User u JOIN u.roles r JOIN r.permissions p 
                        WHERE u.username = :username AND p.resource = :resource AND p.action = :action
                    """, Long.class);
        query.setParameter("username", username);
        query.setParameter("resource", resource);
        query.setParameter("action", action);
        return query.getSingleResult() > 0;
    }

}
