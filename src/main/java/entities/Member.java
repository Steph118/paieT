/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;

/**
 *
 * @author steph18
 */
@Entity
@Table(name = "members")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "member_number",nullable = false)
    private Integer memberNumber;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "eglise")
    private Eglise eglise;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
