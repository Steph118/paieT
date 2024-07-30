/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;

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

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", memberNumber=" + memberNumber + ", person=" + person + ", eglise=" + eglise + '}';
    }

}
