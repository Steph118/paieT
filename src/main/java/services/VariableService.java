/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import dao.VariableDao;
import entities.Variable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import service.interfaces.VariableServiceLocal;

import java.util.Optional;

/**
 * @author steph18
 */
@Transactional
@RequestScoped
public class VariableService extends GenericServiceLocalImpl<Variable, Long>
        implements VariableServiceLocal {

    @Inject
    private VariableDao dao;

    @Override
    protected RepositoryDao<Variable, Long> getDAO() {
        return dao;
    }

    @Override
    public Optional<Variable> findByKey(String key) {
        return this.dao.findByKey(key);
    }

}
