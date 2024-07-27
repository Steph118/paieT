/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Address;
import entities.Country;
import entities.Locality;
import entities.Person;
import entities.Sexe;
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
import service.interfaces.PersonServiceLocal;
import service.interfaces.SexeServiceLocal;
import service.interfaces.TypeLocalityServiceLocal;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class PersonBean extends GenericBean<Person, Integer> {

    @EJB
    private PersonServiceLocal personService;
    @EJB
    private LocalityServiceLocal localityService;
    @EJB
    private TypeLocalityServiceLocal typeLocalityService;
    @EJB
    private CountryServiceLocal countryService;
    @EJB
    private SexeServiceLocal sexeService;

    private Country country;
    private Address address;
    private TypeLocality typeLocality;
    private boolean addUser;

    private List<Country> countries = new ArrayList<>();
    private List<TypeLocality> typeLocalities = new ArrayList<>();
    private List<Locality> localities = new ArrayList<>();

    @Override
    public GenericServiceLocal<Person, Integer> getService() {
        return personService;
    }

    @Override
    public void initAdd() {
        this.entity = new Person();
        this.address = new Address();
    }

    @Override
    public void initEntity() {
        super.initEntity();
        this.countries = this.countryService.getAll();
        this.typeLocalities = this.typeLocalityService.getAll();
    }

    public void filterLocality() {
        if (Objects.nonNull(country) && Objects.nonNull(typeLocality)) {
            this.localities = this.localityService.getAll(this.getCountry(), this.getTypeLocality());
        }
    }

    public List<Sexe> listSexes() {
        return sexeService.getAll();
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

    public List<Country> getCountries() {
        return countries;
    }

    public List<TypeLocality> getTypeLocalities() {
        return typeLocalities;
    }

    public List<Locality> getLocalities() {
        return localities;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public TypeLocality getTypeLocality() {
        return typeLocality;
    }

    public void setTypeLocality(TypeLocality typeLocality) {
        this.typeLocality = typeLocality;
    }

    public boolean isAddUser() {
        return addUser;
    }

    public void setAddUser(boolean addUser) {
        this.addUser = addUser;
    }
    
}
