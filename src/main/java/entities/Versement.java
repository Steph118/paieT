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
@Table(name = "versements")
public class Versement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "date_versement", nullable = false)
    private Date dateVersement;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_member")
    private Member member;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sumpaye")
    private SumPaye sumPaye;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontant() {
        return amount;
    }

    public void setMontant(Double montant) {
        this.amount = montant;
    }

    public Date getDateVersement() {
        return dateVersement;
    }

    public void setDateVersement(Date dateVersement) {
        this.dateVersement = dateVersement;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public SumPaye getSumPaye() {
        return sumPaye;
    }

    public void setSumPaye(SumPaye sumPaye) {
        this.sumPaye = sumPaye;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Versement other = (Versement) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Versement{" + "id=" + id + ", montant=" + amount + ", dateVersement=" + dateVersement + ", member=" + member + ", sumPaye=" + sumPaye + '}';
    }

}
