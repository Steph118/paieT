/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;

/**
 *
 * @author steph18
 */

@Entity
@Table(name = "eglises")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Eglise extends Entite{

}
