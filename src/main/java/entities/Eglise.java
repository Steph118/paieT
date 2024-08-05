/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author steph18
 */
@Entity
@DiscriminatorValue(value = "EG")
public class Eglise extends Entite {

    @Column(name = "temple", length = 31, nullable = false)
    private String temple;

    @Transient
    private AtomicInteger compteur = new AtomicInteger(1);

    public Eglise() {
    }

    public String getTemple() {
        return temple;
    }

    public void setTemple(String temple) {
        this.temple = temple;
    }

    public AtomicInteger getCompteur() {
        return compteur;
    }

    public void setCompteur(AtomicInteger compteur) {
        this.compteur = compteur;
    }

}
