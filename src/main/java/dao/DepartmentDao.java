/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Department;

/**
 *
 * @author steph18
 */
public class DepartmentDao extends RepositoryDao<Department, Integer> {

    @Override
    public Class<Department> getEntityClass() {
        return Department.class;
    }

    @Override
    public Integer getId(Department department) {
        return department.getId();
    }
    
}
