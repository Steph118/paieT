/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;

/**
 *
 * @author mediasoft
 */
@Entity
@DiscriminatorValue(value = "ENTITE_SET")
public class EntiteSettings extends Settings {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entite_id")
    private Entite entite;

    public EntiteSettings() {
    }

    public Entite getEntite() {
        return entite;
    }

    public void setEntite(Entite entite) {
        this.entite = entite;
    }

}
