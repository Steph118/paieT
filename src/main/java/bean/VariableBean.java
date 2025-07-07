/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Variable;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import service.interfaces.GenericServiceLocal;
import service.interfaces.VariableServiceLocal;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class VariableBean extends GenericBean<Variable, Long> {

    @Inject
    private VariableServiceLocal variableService;

    @Override
    public GenericServiceLocal<Variable, Long> getService() {
        return variableService;
    }

    @Override
    public void initAdd() {
        this.entity = new Variable();
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
    public String save() {
        return super.save();
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public void beforeUpdate() {
        this.trimEntity();
    }

    @Override
    public void beforeSave() {
        this.trimEntity();
    }

    private void trimEntity() {
        this.entity.setKey(this.entity.getKey().trim());
        this.entity.setValue(this.entity.getValue().trim());
    }

}
