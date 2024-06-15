/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author steph18
 */
@Entity
@Table(name = "loans")
public class Loan extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "label", nullable = false)
    private String label;

    @Column(name = "montant", nullable = false)
    private Double montant;

    @Column(name = "rembourse")
    private boolean rembourse;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "eglise_id")
    private Eglise eglise;

    public Loan() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public boolean isRembourse() {
        return rembourse;
    }

    public void setRembourse(boolean rembourse) {
        this.rembourse = rembourse;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Eglise getEglise() {
        return eglise;
    }

    public void setEglise(Eglise eglise) {
        this.eglise = eglise;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Loan other = (Loan) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Loan{" + "id=" + id + ", label=" + label + ", montant=" + montant + ", rembourse=" + rembourse + ", startDate=" + startDate + ", endDate=" + endDate + ", eglise=" + eglise + '}';
    }
}
