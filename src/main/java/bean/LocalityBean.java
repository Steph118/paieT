/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Country;
import entities.Locality;
import entities.TypeLocality;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import service.interfaces.CountryServiceLocal;
import service.interfaces.GenericServiceLocal;
import service.interfaces.LocalityServiceLocal;
import service.interfaces.TypeLocalityServiceLocal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class LocalityBean extends GenericBean<Locality, Integer> {

    @EJB
    private LocalityServiceLocal localityService;
    @EJB
    private TypeLocalityServiceLocal typeLocalityService;
    @EJB
    private CountryServiceLocal countryService;

    private TypeLocality typeLocalityParent;

    private List<Country> countries = new ArrayList<>();
    private List<TypeLocality> supTypeLocalities = new ArrayList<>();
    private List<Locality> suplocalities = new ArrayList<>();
    private List<TypeLocality> typeLocalities = new ArrayList<>();

    @Override
    public GenericServiceLocal<Locality, Integer> getService() {
        return this.localityService;
    }

    @Override
    public void initAdd() {
        this.entity = new Locality();
    }

    @Override
    public void initEntity() {
        super.initEntity();
        this.countries = this.countryService.getAll();
        this.supTypeLocalities = this.typeLocalityService.getAll();
        this.typeLocalities = this.getSupTypeLocalities();

    }

    public void filterParentLocalilty() {
        if (Objects.nonNull(this.entity.getCountry()) && Objects.nonNull(this.typeLocalityParent)) {
            this.suplocalities = this.localityService.getAll(this.entity.getCountry(), this.typeLocalityParent);
        }
    }

    public void filterLocality() {
        this.filterParentLocalilty();
        this.typeLocalities = Objects.nonNull(this.typeLocalityParent)
                ? this.typeLocalityService.getDescendants(this.typeLocalityParent) : this.supTypeLocalities;
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

    public TypeLocality getTypeLocalityParent() {
        return this.typeLocalityParent;
    }

    public void setTypeLocalityParent(TypeLocality typeLocalityParent) {
        this.typeLocalityParent = typeLocalityParent;
    }

    public List<Country> getCountries() {
        return this.countries;
    }

    public List<TypeLocality> getTypeLocalities() {
        return this.typeLocalities;
    }

    public List<Locality> getSuplocalities() {
        return this.suplocalities;
    }

    public List<TypeLocality> getSupTypeLocalities() {
        return supTypeLocalities;
    }
}
