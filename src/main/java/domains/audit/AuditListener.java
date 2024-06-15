/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domains.audit;

import entities.BaseAuditEntity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

/**
 *
 * @author mawuli
 */
public class AuditListener {
    @PrePersist
    public void setCreatedOn(BaseAuditEntity auditable) {
        auditable.setCreatedAt(LocalDateTime.now());
        auditable.setCreatedBy(LoggedUser.get());
    }
 
    @PreUpdate
    public void setUpdatedOn(BaseAuditEntity auditable) {
        auditable.setUpdatedAt(LocalDateTime.now());
        auditable.setUpdatedBy(LoggedUser.get());
    }
}
