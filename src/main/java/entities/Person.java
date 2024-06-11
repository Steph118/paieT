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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "entite_id")
    private Entite entite;

    @OneToOne(optional = true)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexe")
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

    public String getNom() {
        return firstname;
    }

    public void setNom(String nom) {
        this.firstname = nom;
    }

    public String getPrenom() {
        return name;
    }

    public void setPrenom(String prenom) {
        this.name = prenom;
    }

    public Date getDateNaissance() {
        return birthdate;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.birthdate = dateNaissance;
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

    public Entite getEntite() {
        return entite;
    }

    public void setEntite(Entite entite) {
        this.entite = entite;
    }

    public String getLieuNaissance() {
        return birthplace;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.birthplace = lieuNaissance;
    }

    public Sexe getSexe() {
        return Sexe;
    }

    public void setSexe(Sexe Sexe) {
        this.Sexe = Sexe;
    }

    public Address getAddresse() {
        return address;
    }

    public void setAddresse(Address addresse) {
        this.address = addresse;
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
        return "Person{" + "id=" + id + ", nom=" + firstname + ", prenom=" + name + ", dateNaissance=" + birthdate + ", lieuNaissance=" + birthplace + ", mail=" + mail + ", entite=" + entite + ", user=" + user + ", addresse=" + address + '}';
    }

}
