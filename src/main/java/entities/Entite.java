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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
    @Column(name = "nomination", length = 31)
    private String nomination;

    @Column(name = "numero_aprouve")
    private String numeroAprouve;

    @Lob
    private String logo;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "city",
                column = @Column(name = "entite_city")),
        @AttributeOverride(name = "street",
                column = @Column(name = "entite_street"))
    })
    private Address addresse;

    //@OneToMany(mappedBy = "entite", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    //private List<EntitePersonNotification> entitesPersonNotifications;

    public Entite() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomination() {
        return nomination;
    }

    public void setNomination(String nomination) {
        this.nomination = nomination;
    }

    public String getNumeroAprouve() {
        return numeroAprouve;
    }

    public void setNumeroAprouve(String numeroAprouve) {
        this.numeroAprouve = numeroAprouve;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Address getAddress() {
        return addresse;
    }

    public void setAddress(Address address) {
        this.addresse = address;
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
        return "Entite{" + "id=" + id + ", nomination=" + nomination + ", numeroAprouve=" + numeroAprouve + ", logo=" + logo + ", address=" + addresse + '}';
    }

}
