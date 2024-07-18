/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.BaseEntity;
import exception.BusinessException;
import org.omnifaces.util.Messages;
import service.interfaces.GenericServiceLocal;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @param <E>
 * @param <ID>
 * @author steph18
 */
public abstract class GenericBean<E extends BaseEntity, ID extends Serializable>
        implements Serializable {

    protected static final String LIST_OUTCOME = "list";
    protected static final String EDIT_OUTCOME = "edit";
    protected final Logger logger;
    protected boolean updating;
    protected E entity;
    protected ID entityId;
    protected List<E> list;

    public GenericBean() {
        this.logger = Logger.getLogger(this.getClass().getName());
    }

    public abstract GenericServiceLocal<E, ID> getService();

    public void initList() {
        this.list = this.getService().getAll();
    }

    public void beforeSave() {
    }

    public String save() {
        try {
            logger.log(Level.INFO, "GenericBean Save...");
            this.getService().save(this.entity);
            Messages.addFlashGlobalInfo("Ajout effectué avec succès.");
            this.logger.log(Level.INFO, "Enregistrement de {0} effectué: {1}.", new Object[]{this.entity.getClass().getSimpleName(), this.entity});
            return cancel();
        } catch (BusinessException ex) {
            Messages.addGlobalError(ex.getMessage());
            this.logger.log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        } catch (Exception ex) {
            Messages.addGlobalError("Une erreur est survenue lors de l'ajout.");
            this.logger.log(Level.SEVERE, ex, () -> "Erreur à l'ajout de l'objet: " + this.entity);
            return null;
        }

    }

    public abstract void initAdd();

    public abstract boolean canAdd();

    public abstract boolean canDelete();

    public abstract boolean canDetails();

    public abstract boolean canUpdate();

    public ID getId(E e) {
        return null;
    }

    public void loadEntity() {
        this.entity = this.getService().findById(this.entityId);
    }

    public void initEntity() {
        if (this.entityId == null) {
            this.initAdd();
        } else {
            this.loadEntity();
        }
    }

    public void initDetails() {
        if (this.entityId != null) {
            this.entity = this.getService().findById(this.entityId);
        }
    }

    public void afterSave() {
    }

    public void beforeDelete() {
    }

    public String delete(E e) {
        try {
            this.logger.log(Level.INFO, "GenericBean delete...");
            this.getService().delete(e);
            this.logger.log(Level.INFO, "Suppression de {0} effectué: {1}.", new Object[]{this.entity.getClass().getSimpleName(), this.entity});
            Messages.addFlashGlobalInfo("Suppression effectuée avec succès.");
        } catch (BusinessException ex) {
            Messages.addFlashGlobalError(ex.getMessage());
            this.logger.log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            Messages.addFlashGlobalError("Une erreur est survenue lors de la suppression.");
            this.logger.log(Level.SEVERE, ex, () -> "Erreur à la suppression de l'objet: " + e);
        }
        return cancel();
    }

    public String delete() {
        return this.delete(this.entity);
    }

    public void afterDelete() {

    }

    public void beforeUpdate() {
    }

    public String update() {
        try {
            logger.log(Level.INFO, "GenericBean update...");
            this.entity = this.getService().update(this.entity);
            Messages.addFlashGlobalInfo("Mise à jour effectuée avec succès.");
            this.logger.log(Level.INFO, "Mise à jour de {0} effectué: {1}.", new Object[]{this.entity.getClass().getSimpleName(), this.entity});
            return cancel();
        } catch (BusinessException ex) {
            Messages.addGlobalError(ex.getMessage());
            this.logger.log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        } catch (Exception ex) {
            Messages.addGlobalError("Une erreur est survenue lors de la mise à jour.");
            this.logger.log(Level.SEVERE, ex, () -> "Erreur à la mise à jour de l'objet: " + this.entity);
            return null;
        }
    }

    public void afterUpdate() {

    }

    public String cancel() {
        return LIST_OUTCOME + "?faces-redirect=true";
    }

    public String gotoEdit() {
        return EDIT_OUTCOME + "?faces-redirect=true";
    }

    public boolean isUpdating() {
        return this.entityId != null;
    }

    public void setUpdating(boolean updating) {
        this.updating = updating;
    }

    public E getEntity() {
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
    }

    public ID getEntityId() {
        return entityId;
    }

    public void setEntityId(ID entityId) {
        this.entityId = entityId;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}
