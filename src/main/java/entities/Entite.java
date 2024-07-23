/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * @author Mediasoft
 */
@Entity
@Table(name = "entites")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "entite_type")
@DiscriminatorValue(value = "E")
public class Entite extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(min = 3, max = 31, message = "Minumum 3 caracteres et Maximum 31 caracteres")
    @Column(name = "label", length = 31, nullable = false)
    private String label;

    @Column(name = "mail", unique = true)
    private String mail;

    @Column(name = "contact1", unique = true)
    private String contact1;
    
    @Column(name = "contact2", unique = true)
    private String contact2;

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
    private Address address;

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

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact) {
        this.contact1 = contact;
    }
    
    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getContact2() {
        return contact2;
    }
    
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
        return "Entite{" + "id=" + id + ", label=" + label + ", mail=" + mail + ", contact=" + contact1 + ", contact2=" + contact2 + ", logo=" + logo + ", addresse=" + address + ", locality=" + locality + '}';
    }
}
