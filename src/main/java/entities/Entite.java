/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

/**
 *
 * @author Mediasoft
 */
@Entity
public class Entite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nomination")
    private String nomination;
    
    @Column(name = "numero_aprouve")
    private String numeroAprouve;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        return "Entite{" + "id=" + id + ", nomination=" + nomination + ", numeroAprouve=" + numeroAprouve + '}';
    }
    
}
