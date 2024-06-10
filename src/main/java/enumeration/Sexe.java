/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enumeration;

/**
 *
 * @author samiesoft
 */
public enum Sexe {
    
    M("Masculin"),
    F("Féminin");
    
    private final String libelle;

    private Sexe(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }  

    @Override
    public String toString() {
        return "Sexe{" + "name=" + name() + ", libelle=" + libelle + '}';
    }
    
}
