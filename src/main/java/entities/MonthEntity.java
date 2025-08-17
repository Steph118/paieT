/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * @author samiesoft
 */
@Entity
@Table(name = "months")
public class MonthEntity extends BaseEntity {

    public static final String JAN = "JAN";
    public static final String FEV = "FEV";
    public static final String MAR = "MAR";
    public static final String AVR = "AVR";
    public static final String MAI = "MAI";
    public static final String JUI = "JUI";
    public static final String JUL = "JUL";
    public static final String AOU = "AOU";
    public static final String SEP = "SEP";
    public static final String OCT = "OCT";
    public static final String NOV = "NOV";
    public static final String DEC = "DEC";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code", length = 3, unique = true, nullable = false)
    private String code;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    public MonthEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
        final MonthEntity other = (MonthEntity) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Month{" + "id=" + id + ", code=" + code + ", libelle=" + libelle + '}';
    }

}
