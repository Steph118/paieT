/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enumeration;

/**
 *
 * @author samiesoft
 */
public enum Mois {

    JANV("Janvier"),
    FEV("Février"),
    MAR("Mars"),
    AVR("Avril"),
    MAI("Mai"),
    JUI("Juin"),
    JUL("Juillet"),
    AOU("Août"),
    SEP("Septembre"),
    OCT("Octobre"),
    NOV("Novembre"),
    DEC("Décembre");

    private final String libelle;

    private Mois(String libelle) {
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
