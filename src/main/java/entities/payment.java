/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.Date;
import java.util.Objects;

/**
 * @author steph18
 */
@Entity
@Table(name = "payments")
public class payment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "paymentDate", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime paymentDate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_member")
    private Member member;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sumpaid")
    private SumPaid sumPaid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMontant() {
        return amount;
    }

    public void setMontant(BigDecimal montant) {
        this.amount = montant;
    }

    public LocalDateTime getDateVersement() {
        return paymentDate;
    }

    public void setDateVersement(LocalDateTime dateVersement) {
        this.paymentDate = dateVersement;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public SumPaid getSumPaye() {
        return sumPaid;
    }

    public void setSumPaye(SumPaid sumPaye) {
        this.sumPaid = sumPaye;
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
        final payment other = (payment) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "payment{" + "id=" + id + ", amount=" + amount + ", paymentDate=" + paymentDate + ", member=" + member + ", sumPaid=" + sumPaid + '}';
    }

}
