/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enumeration;

/**
 *
 * @author samiesoft
 */
public enum Month {

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

    private final String label;

    private Month(String libelle) {
        this.label = libelle;
    }

    public String getLibelle() {
        return label;
    }

    @Override
    public String toString() {
        return "Month{" + " name=" + name() + ", label=" + label + '}';
    }

    

}
