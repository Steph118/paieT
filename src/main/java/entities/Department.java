/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;

/**
 * @author steph18
 */
@Entity
@Table(name = "departments")
public class Department {
    private static final String MEN_DEPARTMENT = "MD";
    private static final String WOMEN_DEPARTMENT = "WD";
    private static final String CHILDREEN_DEPARTMENT = "CD";
    private static final String YOUNG_DEPARTMENT = "YD";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "label", nullable = false)
    private Long label;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
