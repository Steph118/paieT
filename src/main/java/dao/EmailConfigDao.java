/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.EmailConfig;
import enumeration.EmailProvider;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

import java.util.Optional;
import java.util.logging.Level;

/**
 * @author steph18
 */
@ApplicationScoped
@Transactional
public class EmailConfigDao extends RepositoryDao<EmailConfig, Long> {

    public EmailConfigDao() {
        super(EmailConfig.class);
    }

    public Optional<EmailConfig> findByActiveAndProvider(EmailProvider provider) {
        try {
            EmailConfig config
                    = this.em.createNamedQuery("EmailConfig.findByActiveAndProvider",
                            EmailConfig.class)
                    .setParameter("provider", provider)
                    .getSingleResult();
            return Optional.of(config);
        } catch (NoResultException e) {
            LOGGER.log(Level.SEVERE, "EmailConfig : NoResultException for findByActiveAndProvider ");
            return Optional.empty();
        }
    }

}
