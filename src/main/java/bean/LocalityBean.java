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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import service.interfaces.CountryServiceLocal;
import service.interfaces.GenericServiceLocal;
import service.interfaces.LocalityServiceLocal;
import service.interfaces.TypeLocalityServiceLocal;

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
    private List<TypeLocality> localities = new ArrayList<>();

    @Override
    public GenericServiceLocal<Locality, Integer> getService() {
        return localityService;
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

    }

    public void filterParentLocalilty() {
        if (Objects.nonNull(this.entity.getCountry()) && Objects.nonNull(this.typeLocalityParent)) {
            this.suplocalities = this.localityService.getAll(this.entity.getCountry(), this.typeLocalityParent);
        }
    }

    public void filterLocality() {
        this.typeLocalities = Objects.nonNull(this.typeLocalityParent)
                ? this.typeLocalityService.getDescendants(this.typeLocalityParent) : supTypeLocalities;
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
        return typeLocalityParent;
    }

    public void setTypeLocalityParent(TypeLocality typeLocalityParent) {
        this.typeLocalityParent = typeLocalityParent;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public List<TypeLocality> getTypeLocalities() {
        return typeLocalities;
    }

    public List<Locality> getSuplocalities() {
        return suplocalities;
    }

    public List<TypeLocality> getLocalities() {
        return localities;
    }

    public List<TypeLocality> getSupTypeLocalities() {
        return supTypeLocalities;
    }
}
