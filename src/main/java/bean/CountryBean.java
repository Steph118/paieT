/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Country;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import service.interfaces.CountryServiceLocal;
import service.interfaces.GenericServiceLocal;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class CountryBean extends GenericBean<Country, Integer> {

    @EJB
    private CountryServiceLocal CountryService;

    @Override
    public GenericServiceLocal<Country, Integer> getService() {
        return CountryService;
    }

    @Override
    public void initAdd() {
        this.entity = new Country();
    }

}
