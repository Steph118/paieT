/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Permission;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.stream.Collectors;

/**
 * @author steph18
 */
@Transactional
public class PermisionDao extends RepositoryDao<Permission, Long> {

    public PermisionDao() {
        super(Permission.class);
    }

    public Optional<Permission> getByCode(String code) {
        try {
            Permission p
                    = this.em.createQuery("SELECT p FROM Permission p WHERE p.code = :code",
                            Permission.class)
                            .setParameter("code", code)
                            .getSingleResult();
            return Optional.ofNullable(p);
        } catch (NoResultException e) {
            LOGGER.log(Level.SEVERE, "Empty permission");
            return Optional.empty();
        }
    }

    public Map<String, Permission> getExistingPermissions() {
        return em.createQuery("SELECT p FROM Permission p", Permission.class)
                .getResultStream()
                .collect(Collectors.toMap(Permission::getCode, p -> p));
    }


}
