/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.MonthDao;
import dao.RepositoryDao;
import entities.MonthEntity;
import entities.SumPromised;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;
import service.interfaces.MonthServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class MonthService extends GenericServiceLocalImpl<MonthEntity, Integer> implements MonthServiceLocal {

    @EJB
    private MonthDao dao;

    @Override
    protected RepositoryDao<MonthEntity, Integer> getDAO() {
        return dao;
    }

    @Override
    public List<MonthEntity> findMontNotPaid(SumPromised s) {
        return dao.findMontNotPaid(s);
    }

}
