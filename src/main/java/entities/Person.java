/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author steph18
 */
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
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Column(name = "lieu_naissance")
    private String lieuNaissance;

    @Column(name = "mail", nullable = false, unique = true)
    private String mail;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "entite_id")
    private Entite entite;

    @OneToOne(optional = true)
    @JoinColumn(name = "user_id")
    private User user;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "city",
                column = @Column(name = "pers_city")),
        @AttributeOverride(name = "street",
                column = @Column(name = "pers_street"))
    })
    private Address addresse;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "person_phones",
            joinColumns = {
                @JoinColumn(name = "person_id")
            })
    @Column(name = "phone_number")
    private Set<String> phones = new HashSet<>();

    public Person() {

    }

    public Person(Integer id, String nom, String prenom, Date dateNaissance, String lieuNaissance, String mail, Entite entite, User user, Address addresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.mail = mail;
        this.entite = entite;
        this.user = user;
        this.addresse = addresse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
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
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public Address getAddresse() {
        return addresse;
    }

    public void setAddresse(Address addresse) {
        this.addresse = addresse;
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
        return "Person{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", lieuNaissance=" + lieuNaissance + ", mail=" + mail + ", entite=" + entite + ", user=" + user + ", addresse=" + addresse + '}';
    }

}
