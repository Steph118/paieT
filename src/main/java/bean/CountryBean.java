/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Country;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import service.interfaces.CountryServiceLocal;
import service.interfaces.GenericServiceLocal;
import utils.PermsConstant;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class CountryBean extends GenericBean<Country, Integer>  {

    @Inject
    protected SessionBean sessionBean;
    @Inject
    private CountryServiceLocal countryService;

    @Override
    public GenericServiceLocal<Country, Integer> getService() {
        return countryService;
    }

    @Override
    public void initAdd() {
        this.entity = new Country();
    }

    @Override
    public boolean canAdd() {
        return sessionBean.filterPermission(PermsConstant.PAYS_ALL, PermsConstant.PAYS_ADD);
    }

    @Override
    public boolean canDelete() {
        return sessionBean.filterPermission(PermsConstant.PAYS_ALL, PermsConstant.PAYS_DELETE);
    }

    @Override
    public boolean canDetails() {
        return sessionBean.filterPermission(PermsConstant.PAYS_ALL, PermsConstant.PAYS_DETAILS);
    }

    @Override
    public boolean canUpdate() {
        return sessionBean.filterPermission(PermsConstant.PAYS_ALL, PermsConstant.PAYS_EDIT);
    }

}
