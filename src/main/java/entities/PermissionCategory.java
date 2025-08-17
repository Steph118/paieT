/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import jakarta.persistence.*;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author persistence
 */
@Entity
@Table(name = "permission_categories")
public class PermissionCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "label", nullable = false)
    private String label;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryPermission", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Permission> permissions = new LinkedList<>();

    public PermissionCategory() {
    }

    public PermissionCategory(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public PermissionCategory(String code, String label, String description) {
        this.code = code;
        this.label = label;
        this.description = description;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        permissions.isEmpty();
        stream.defaultWriteObject();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.code);
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
        final PermissionCategory other = (PermissionCategory) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "PermissionCategory{" + "id=" + id + ", code=" + code + ", label=" + label + ", description=" + description + '}';
    }

}
