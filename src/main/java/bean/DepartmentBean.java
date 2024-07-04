/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Department;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import service.interfaces.DepartmentServiceLocal;
import service.interfaces.GenericServiceLocal;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class DepartmentBean extends GenericBean<Department, Integer> {

    @EJB
    private DepartmentServiceLocal departmentService;

    @Override
    public GenericServiceLocal<Department, Integer> getService() {
        return departmentService;
    }

    @Override
    public void initAdd() {
        this.entity = new Department();
    }

    @Override
    public boolean canAdd() {
        return true;
    }

    @Override
    public boolean canDelete() {
        return true;
    }

    @Override
    public boolean canDetails() {
        return true;
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

}
