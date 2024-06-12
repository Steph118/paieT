/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;

import java.util.Date;

/**
 *
 * @author steph18
 */
@Entity
@Table(name = "sum_contributors")
public class SumContributor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @ManyToOne()
    @JoinColumn(name = "contributor")
    private Contributor contributor;

    @Column(name = "montant")
    private Double montant;

    @Column(name = "contribution_date")
    @Temporal(TemporalType.DATE)
    private Date contributionDate;
}
