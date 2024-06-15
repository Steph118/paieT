/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 *
 * @author persistence
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    protected static final long serialVersionUID = 1L;
    
    @XmlTransient
    @Column(name = "version", nullable = false)
    private int version = 1;

    @XmlTransient
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
