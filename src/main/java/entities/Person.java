/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 * @author steph18
 */
import jakarta.persistence.*;
import java.time.LocalDate;

import java.util.Date;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type")
@DiscriminatorValue(value = "pers")
public class Person extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birth_date", columnDefinition = "DATE")
    private LocalDate birthdate;

    @Column(name = "birth_place")
    private String birthplace;

    @Column(name = "mail", unique = true)
    private String mail;

    @Column(name = "phone_code", nullable = false)
    private String phoneCode;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @OneToOne(optional = true)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "locality_id")
    private Locality locality;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "sexe_id")
    private Sexe sexe;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "house",
                column = @Column(name = "pers_house")),
        @AttributeOverride(name = "street",
                column = @Column(name = "pers_street"))
    })
    private Address address;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "eglise_id")
    private Eglise eglise;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getContact() {
        return this.phoneCode + StringUtils.deleteWhitespace(this.telephone);
    }

    public Eglise getEglise() {
        return eglise;
    }

    public void setEglise(Eglise eglise) {
        this.eglise = eglise;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        return Objects.equals(this.id, other.id);
    }
    
    public String getFullName(){
        return this.name + " " + this.firstname;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstname=" + firstname + ", name=" + name + ", birthdate=" + birthdate + ", birthplace=" + birthplace + ", mail=" + mail + ", phoneCode=" + phoneCode + ", telephone=" + telephone + ", address=" + address + '}';
    }

}
