/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.DepartmentDao;
import dao.RepositoryDao;
import entities.Department;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.DepartmentServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class DepartmentService extends GenericServiceLocalImpl<Department, Integer>
        implements DepartmentServiceLocal {

    @EJB
    private DepartmentDao dao;

    @Override
    protected RepositoryDao<Department, Integer> getDAO() {
        return dao;
    }

}
