/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Department;
import jakarta.ejb.Stateless;

/**
 * @author steph18
 */
@Stateless
public class DepartmentDao extends RepositoryDao<Department, Integer> {

    public DepartmentDao() {
        super(Department.class);
    }

}
