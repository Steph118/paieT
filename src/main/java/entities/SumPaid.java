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
import java.util.Objects;

@Entity
@Table(name = "sumpaid")
public class SumPaid extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "paid")
    private boolean paid;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "month")
    private Month month;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "sumpromised_id")
    private SumPromised sumPromised;

    public SumPaid() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public boolean isPaye() {
        return paid;
    }

    public void setPaye(boolean paye) {
        this.paid = paye;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public SumPromised getPromesse() {
        return sumPromised;
    }

    public void setPromesse(SumPromised promesse) {
        this.sumPromised = promesse;
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
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "SumPaye{" + "id=" + id + ", amount=" + amount + ", paye=" + paid + ", month=" + month + ", promesse=" + sumPromised + '}';
    }

}
