/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author Mediasoft
 */
@Entity
@Table(name = "entites", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"phone_code1", "contact1", "phone_code2", "contact2"})})
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

    @Column(name = "mail", unique = true, nullable = false)
    private String mail;

    @Column(name = "phone_code1", nullable = false)
    private String phoneCode1;

    @Column(name = "telephone1", nullable = false)
    private String telephone1;

    @Column(name = "phone_code2")
    private String phoneCode2;

    @Column(name = "telephone2")
    private String telephone2;

    @Lob
    @Column(name = "logo")
    private String logo;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "house",
                column = @Column(name = "entite_house")),
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

    public String getPhoneCode1() {
        return phoneCode1;
    }

    public void setPhoneCode1(String phoneCode1) {
        this.phoneCode1 = phoneCode1;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getPhoneCode2() {
        return phoneCode2;
    }

    public void setPhoneCode2(String phoneCode2) {
        this.phoneCode2 = phoneCode2;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
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

    public String getContact1() {
        return this.phoneCode1 + StringUtils.deleteWhitespace(this.telephone1);
    }

    public String getContact2() {
        return this.phoneCode2 + StringUtils.deleteWhitespace(this.telephone2);
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
        return "Entite{" + "id=" + id + ", label=" + label + ", mail=" + mail + ", phoneCode1=" + phoneCode1 + ", contact1=" + telephone1 + ", phoneCode2=" + phoneCode2 + ", contact2=" + telephone2 + ", logo=" + logo + '}';
    }
}
