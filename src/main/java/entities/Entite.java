/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.util.Objects;

/**
 *
 * @author Mediasoft
 */
@Entity
@Table(name = "entites")
public class Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(min = 3, max = 31, message = "Vous avez atteint le nombre de caractères requis")
    @Column(name = "label", length = 31, nullable = false)
    private String label;

    @Column(name = "mail", unique = true)
    private String mail;

    @Column(name = "contact", unique = true)
    private String contact;

    @Lob
    @Column(name = "logo")
    private String logo;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "city",
                column = @Column(name = "entite_city")),
        @AttributeOverride(name = "street",
                column = @Column(name = "entite_street"))
    })
    private Address addresse;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "locality_id")
    private Locality locality;

    public Entite() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Address getAddresse() {
        return addresse;
    }

    public void setAddresse(Address addresse) {
        this.addresse = addresse;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Entite other = (Entite) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Entite{" + "id=" + id + ", label=" + label + ", mail=" + mail + ", contact=" + contact + ", logo=" + logo + ", addresse=" + addresse + ", locality=" + locality + '}';
    }

}
