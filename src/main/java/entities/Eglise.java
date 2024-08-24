/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Objects;

/**
 * @author steph18
 */
@Entity
@DiscriminatorValue(value = "EG")
public class Eglise extends Entite {

    @Column(name = "temple", length = 31, nullable = false)
    private String temple;

    public Eglise() {
    }

    public String getTemple() {
        return temple;
    }

    public void setTemple(String temple) {
        this.temple = temple;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.temple);
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
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Eglise{" + "temple=" + temple + '}' + super.toString();
    }

}
