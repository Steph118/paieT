/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

/**
 *
 * @author steph18
 */
@Entity
@Table(name = "versements")
public class Versement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "montant", nullable = false)
    private Double montant;
    
    @Column(name = "date_versement", nullable = false)
    private Date dateVersement;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Column(name = "id_member")
    private Member member;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Column(name = "id_sumpaye")
    private SumPaye sumPaye;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
