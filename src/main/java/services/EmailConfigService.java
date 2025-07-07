/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.EmailConfigDao;
import dao.RepositoryDao;
import entities.EmailConfig;
import enumeration.EmailProvider;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.Optional;
import service.interfaces.EmailConfigServiceLocal;

/**
 * @author steph18
 */
@Transactional
@ApplicationScoped
public class EmailConfigService extends GenericServiceLocalImpl<EmailConfig, Long> implements EmailConfigServiceLocal {

    @Inject
    private EmailConfigDao dao;

    @Override
    protected RepositoryDao<EmailConfig, Long> getDAO() {
        return dao;
    }

    @Override
    public Optional<EmailConfig> findByActiveAndProvider(EmailProvider provider) {
        return this.dao.findByActiveAndProvider(provider);
    }

}
