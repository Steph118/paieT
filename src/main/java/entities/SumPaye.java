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
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sumpayes")
public class SumPaye {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "montant", nullable = false)
    private Double amount;

    @Column(name = "paye")
    private boolean paye;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "month")
    private Month month;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "promesse_id")
    private Promesse promesse;

    public SumPaye() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public boolean isPaye() {
        return paye;
    }

    public void setPaye(boolean paye) {
        this.paye = paye;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Promesse getPromesse() {
        return promesse;
    }

    public void setPromesse(Promesse promesse) {
        this.promesse = promesse;
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
        final SumPaye other = (SumPaye) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "SumPaye{" + "id=" + id + ", amount=" + amount + ", paye=" + paye + ", month=" + month + ", promesse=" + promesse + '}';
    }

}
