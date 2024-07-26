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
    private List<TypeLocality> supTypeLocalitie