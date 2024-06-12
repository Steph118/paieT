/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author steph18
 */

import enumeration.Month;
import jakarta.persistence.*;

@Entity
@Table(name = "sumpayes")
public class SumPaye {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "montant", nullable = false)
    private Double montant;

    @Column(name = "paye")
    private boolean paye;

    @Enumerated(EnumType.STRING)
    @Column(name = "month")
    private Month month;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "promesse_id")
    private Promesse promesse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
