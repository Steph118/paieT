/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Address;
import entities.Country;
import entities.Department;
import entities.Eglise;
import entities.Loan;
import entities.Locality;
import entities.Member;
import entities.Person;
import entities.Role;
import entities.Sexe;
import entities.SumPromised;
import entities.TypeLocality;
import entities.User;
import entities.Year;
import exception.BusinessException;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import org.apache.commons.lang3.StringUtils;
import org.omnifaces.util.Messages;
import service.interfaces.CountryServiceLocal;
import service.interfaces.DepartmentServiceLocal;
import service.interfaces.EgliseServiceLocal;
import service.interfaces.GenericServiceLocal;
import service.interfaces.LoanServiceLocal;
import service.interfaces.LocalityServiceLocal;
import service.interfaces.PersonServiceLocal;
import service.interfaces.SexeServiceLocal;
import service.interfaces.TypeLocalityServiceLocal;
import service.interfaces.YearServiceLocal;

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
    @EJB
    private DepartmentServiceLocal departmentService;
    @EJB
    private EgliseServiceLocal egliseService;
    @EJB
    private LoanServiceLocal loanService;
    @EJB
    private YearServiceLocal yearService;

    private int previousEgliseId;
    private Country country;
    private Address address;
    private TypeLocality typeLocality;
    private Member member;
    private User user;
    private SumPromised sumPromised;
    private boolean addUser;
    private boolean addMember;

    private List<Locality> localities = new ArrayList<>();
    private List<Year> years = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

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
    public void loadEntity() {
        super.loadEntity();
        this.previousEgliseId = this.entity.getEglise().getId();
        this.loadData();
    }

    private void loadData() {
        this.address = this.entity.getAddress();
        this.localities = this.localityService.getAll(this.entity.getLocality().getCountry(),
                this.entity.getLocality().getLocalityType());
    }

    @Override
    public void initEntity() {
        super.initEntity();
    }

    @Override
    public void beforeSave() {
        this.entity.setAddress(getAddress());
        if (StringUtils.isEmpty(this.entity.getMail())) {
            this.entity.setMail(null);
        }
    }

    @Override
    public void beforeUpdate() {
        this.beforeSave();
    }

    @Override
    public String update() {
        System.err.println("verify : " + (this.entity.getEglise().getId() == previousEgliseId));
        return (this.entity.getEglise().getId() == previousEgliseId) ? super.update() : update2();
    }

    public String update2() {
        try {
            logger.log(Level.INFO, "Update person and member");
            this.entity = this.personService.update2(this.entity);
            Messages.addFlashGlobalInfo("Mise à jour effectuée avec succès.");
            this.logger.log(Level.INFO, "Mise à jour de {0} effectué: {1}.", new Object[]{this.entity.getClass().getSimpleName(), this.entity});
            return cancel();
        } catch (BusinessException ex) {
            Messages.addGlobalError(ex.getMessage());
            this.logger.log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        } catch (Exception ex) {
            Messages.addGlobalError("Une erreur est survenue lors de la mise à jour.");
            this.logger.log(Level.SEVERE, ex, () -> "Erreur à la mise à jour de l'objet: " + this.entity);
            return null;
        }
    }

    public void filterLocality() {
        if (Objects.nonNull(country) && Objects.nonNull(typeLocality)) {
            this.localities = this.localityService.getAll(this.getCountry(), this.getTypeLocality());
        }
    }

    public void addMember() {
        this.years = yearService.getAll();
        //Recuperer en fonction de eglise;
        this.loans = loanService.getAll();
        System.err.println("eglise : " + this.entity.getEglise());
    }

    public void addUser() {

    }

    public String memberChurche() {
        return this.entity.getEglise() != null ? this.entity.getEglise().getLabel() : null;
    }

    public List<Role> listRoles() {
        return new ArrayList<>();
    }

    public List<Sexe> listSexes() {
        return sexeService.getAll();
    }

    public List<Eglise> listEglises() {
        return egliseService.getAll();
    }

    public List<Department> listDepartements() {
        return departmentService.getAll();
    }

    public List<Country> listCountries() {
        return countryService.getAll();
    }

    public List<TypeLocality> listTypeLocalities() {
        return typeLocalityService.getAll();
    }

    public List<Year> getYears() {
        return years;
    }

    public List<Loan> getLoans() {
        return loans;
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

    public boolean isAddMember() {
        return addMember;
    }

    public void setAddMember(boolean addMember) {
        this.addMember = addMember;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SumPromised getSumPromised() {
        return sumPromised;
    }

    public void setSumPromised(SumPromised sumPromised) {
        this.sumPromised = sumPromised;
    }

}
