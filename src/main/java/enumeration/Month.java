/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
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

    private static final Logger log = LoggerFactory.getLogger(Month.class);
    private final String label;

    private Month(String libelle) {
        this.label = libelle;
    }

    public String getLibelle() {
        return label;
    }

    public static List<Month> getListMonth(){
            return List.of(Month.values());
    }
    @Override
    public String toString() {
        return "Month{" + " name=" + name() + ", label=" + label + '}';
    }


}
