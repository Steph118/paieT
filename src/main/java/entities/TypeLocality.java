/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author steph18
 */
@Entity
@Table(name = "localities_types")
public class TypeLocality extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "label")
    private String label;

    @Column(name = "root", nullable = false)
    private boolean root;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_type_locality")
    private TypeLocality typeLocalityParent;

    @OneToMany(mappedBy = "typeLocalityParent")
    private List<TypeLocality> childreen = new ArrayList<>();

    public TypeLocality() {
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

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    public TypeLocality getTypeLocalityParent() {
        return typeLocalityParent;
    }

    public void setTypeLocalityParent(TypeLocality typeLocalityParent) {
        this.typeLocalityParent = typeLocalityParent;
    }

    public List<TypeLocality> getChildreen() {
        return childreen;
    }

    public void setChildreen(List<TypeLocality> childreen) {
        this.childreen = childreen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final TypeLocality other = (TypeLocality) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "TypeLocality{" + "id=" + id + ", label=" + label + ", root=" + root + '}';
    }

}
