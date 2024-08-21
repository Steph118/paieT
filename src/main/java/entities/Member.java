/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author steph18
 */
@Entity
@Table(name = "members", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"eglise_id", "member_number"})})
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "member_number", nullable = false)
    private Integer memberNumber;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "eglise_id")
    private Eglise eglise;

    public Member() {
    }

    public Member getMember(Member m) {
        this.id = m.getId();
        this.memberNumber = m.getMemberNumber();
        this.person = m.getPerson();
        this.eglise = m.getEglise();
        return this;
    }

    public Member(Member m) {
        this.id = m.getId();
        this.memberNumber = m.getMemberNumber();
        this.person = m.getPerson();
        this.eglise = m.getEglise();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(Integer memberNumber) {
        this.memberNumber = memberNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Eglise getEglise() {
        return eglise;
    }

    public void setEglise(Eglise eglise) {
        this.eglise = eglise;
    }

    @PrePersist
    public void genererNumeroMembre() {
        AtomicInteger compteur = eglise.getCompteur();
        this.setMemberNumber(compteur.getAndIncrement());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.memberNumber);
        hash = 29 * hash + Objects.hashCode(this.person);
        hash = 29 * hash + Objects.hashCode(this.eglise);
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
        final Member other = (Member) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.memberNumber, other.memberNumber)) {
            return false;
        }
        if (!Objects.equals(this.person, other.person)) {
            return false;
        }
        return Objects.equals(this.eglise, other.eglise);
    }

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", memberNumber=" + memberNumber + ", person=" + person + ", eglise=" + eglise + '}';
    }

}
