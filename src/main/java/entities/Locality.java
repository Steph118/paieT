/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author steph18
 */
@Entity
@Table(name = "localities")
public class Locality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "label", nullable = false)
    private String label;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_locality")
    private Locality parent;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "locality_type")
    private LocalityType localityType;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "country")
    private Country country;

    @OneToMany(mappedBy = "parent")
    private List<Locality> childreen = new ArrayList<>();

    public Locality() {
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

    public Locality getParent() {
        return parent;
    }

    public void setParent(Locality parent) {
        this.parent = parent;
    }

    public LocalityType getLocalityType() {
        return localityType;
    }

    public void setLocalityType(LocalityType localityType) {
        this.localityType = localityType;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Locality> getChildreen() {
        return childreen;
    }

    public void setChildreen(List<Locality> childreen) {
        this.childreen = childreen;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Locality other = (Locality) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Locality{" + "id=" + id + ", label=" + label + ", parent=" + parent + ", localityType=" + localityType + ", country=" + country + '}';
    }

}
