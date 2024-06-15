/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;

import java.util.Objects;

/**
 *
 * @author steph18
 */
@Entity
@Table(name = "localities_types")
public class TypeLocality extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "label")
    private String label;

    public TypeLocality() {
    }

    public TypeLocality(Integer id, String label) {
        this.id = id;
        this.label = label;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final TypeLocality other = (TypeLocality) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "LocalityType{" + "id=" + id + ", label=" + label + '}';
    }

}
