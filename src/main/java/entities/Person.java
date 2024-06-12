/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author steph18
 */
import enumeration.Sexe;
import jakarta.persistence.*;
import java.io.Serializable;

import java.util.*;

@Entity
@Table(name = "persons")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String firstname;

    @Column(name = "prenom", nullable = false)
    private String name;

    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @Column(name = "lieu_naissance")
    private String birthplace;

    @Column(name = "mail", nullable = false, unique = true)
    private String mail;

    @OneToOne(optional = true)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entite_id")
    private Locality locality;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexe", nullable = false)
    private Sexe Sexe;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "city",
                column = @Column(name = "pers_city")),
        @AttributeOverride(name = "street",
                column = @Column(name = "pers_street"))
    })
    private Address address;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "person_phones",
            joinColumns = {
                @JoinColumn(name = "person_id")
            })
    @Column(name = "phone_number")
    private Set<String> phones = new HashSet<>();

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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
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

    public enumeration.Sexe getSexe() {
        return Sexe;
    }

    public void setSexe(enumeration.Sexe sexe) {
        Sexe = sexe;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
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

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstname=" + firstname + ", name=" + name + ", birthdate=" + birthdate + ", birthplace=" + birthplace + ", mail=" + mail + ", locality=" + locality + ", user=" + user + ", Sexe=" + Sexe + ", address=" + address + '}';
    }

}
