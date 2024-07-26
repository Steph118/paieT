/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Address;
import entities.Country;
import entities.Eglise;
import entities.Locality;
import entities.TypeLocality;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import service.interfaces.CountryServiceLocal;
import service.interfaces.EgliseServiceLocal;
import service.interfaces.GenericServiceLocal;
import service.interfaces.LocalityServiceLocal;
import service.interfaces.TypeLocalityServiceLocal;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class EgliseBean extends GenericBean<Eglise, Integer> {

    @EJB
    private EgliseServiceLocal egliseService;
    @EJB
    private LocalityServiceLocal localityService;
    @EJB
    private TypeLocalityServiceLocal typeLocalityService;
    @EJB
    private CountryServiceLocal countryService;

    private Country country;
    private Address address;
    private TypeLocality typeLocality;
    private String phoneCode1;
    private String phoneCode2;

    private List<Country> countries = new ArrayList<>();
    private List<Locality> localities = new ArrayList<>();
    private List<TypeLocality> typeLocalities = new ArrayList<>();

    @Override
    public GenericServiceLocal<Eglise, Integer> getService() {
        return egliseService;
    }

    @Override
    public void initAdd() {
        this.entity = new Eglise();
        this.address = new Address();
    }

    @Override
    public void initEntity() {
        super.initEntity();
        this.countries = this.countryService.getAll();
        this.typeLocalities = this.typeLocalityService.getAll();
    }

    @Override
    public void loadEntity() {
        super.loadEntity();
        this.loadData();
    }

    private void loadData() {
        this.address = this.entity.getAddress();
        this.localities = this.localityService.getAll(getCountry(),
                getTypeLocality());
                
    }

    @Override
    public void beforeUpdate() {
        this.beforeSave();
    }

    public void filterLocality() {
        if (Objects.nonNull(country) && Objects.nonNull(typeLocality)) {
            this.localities = this.localityService.getAll(this.getCountry(), this.getTypeLocality());
        }
    }

    @Override
    public void beforeSave() {
        this.entity.setAddress(getAddress());
        if (StringUtils.isBlank(this.entity.getContact2())) {
            this.entity.setPhoneCode2(null);
        }
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public TypeLocality getTypeLocality() {
        return typeLocality;
    }

    public void setTypeLocality(TypeLocality typeLocality) {
        this.typeLocality = typeLocality;
    }

    public String getPhoneCode1() {
        return phoneCode1;
    }

    public void setPhoneCode1(String phoneCode1) {
        this.phoneCode1 = phoneCode1;
    }

    public String getPhoneCode2() {
        return phoneCode2;
    }

    public void setPhoneCode2(String phoneCode2) {
        this.phoneCode2 = phoneCode2;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public List<Locality> getLocalities() {
        return localities;
    }

    public List<TypeLocality> getTypeLocalities() {
        return typeLocalities;
    }
}
