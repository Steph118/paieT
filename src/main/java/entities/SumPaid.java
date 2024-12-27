/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 * @author steph18
 */
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import java.util.Objects;

@Entity
@Table(name = "sumpaids")
public class SumPaid extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "paid", nullable = false)
    private Boolean paid = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "month_id", nullable = false)
    private MonthEntity month;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sumpromised_id", nullable = false)
    private SumPromised sumPromised;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "sumPaid", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Payment> payments = new ArrayList<>();

    public SumPaid() {
    }

    public SumPaid(MonthEntity month, SumPromised sumPromised, Member member) {
        this.month = month;
        this.sumPromised = sumPromised;
        this.member = member;
    }

    public void addPayment(Payment p) {
        p.setSumPaid(this);
        this.payments.add(p);
    }

    public void removePayment(Payment p) {
        this.payments.remove(p);
        p.setSumPaid(null);
    }

    public BigDecimal totalSumPaid() {
        BigDecimal total = BigDecimal.ZERO;
        for (Payment p : this.getPayments()) {
            total = total.add(p.getAmount());
        }
        return total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isPaye() {
        return paid;
    }

    public void setPaye(Boolean paye) {
        this.paid = paye;
    }

    public MonthEntity getMonth() {
        return month;
    }

    public void setMonth(MonthEntity month) {
        this.month = month;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
    
    public boolean isPaid() {
        return paid;
    }

    public SumPromised getSumPromised() {
        return sumPromised;
    }

    public void setSumPromised(SumPromised sumPromised) {
        this.sumPromised = sumPromised;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final SumPaid other = (SumPaid) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.month, other.month)) {
            return false;
        }
        if (!Objects.equals(this.sumPromised, other.sumPromised)) {
            return false;
        }
        return Objects.equals(this.member, other.member);
    }

    @Override
    public String toString() {
        return "SumPaid{" + "id=" + id + ", paid=" + paid + ", month=" + month + ", sumPromised=" + sumPromised + ", member=" + member + '}';
    }

}
