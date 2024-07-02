/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import exception.BusinessException;
import org.omnifaces.util.Messages;
import service.interfaces.GenericServiceLocal;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @param <E>
 * @param <ID>
 * @author steph18
 */
public abstract class GenericBean<E extends Serializable, ID>
        implements Serializable {

    protected static final String LIST_OUTCOME = "list";
    protected static final String EDIT_OUTCOME = "edit";
    protected final Logger logger;
    protected boolean isUpdate;
    protected E entity;
    protected ID entityId;

    public GenericBean() {
        this.logger = Logger.getLogger(this.getClass().getName());
    }

    public abstract GenericServiceLocal<E, ID> getService();

    public void initList() {
    }

    public void beforeSave() {
    }

    public String save() {
        try {
            this.getService().save(this.entity);
            //this.initList();
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

    public void getEntity() {
        this.entity = this.getService().findById(this.getEntityId());
    }

    public void initEntity() {
        if (this.entityId == null) {
            initAdd();
        } else {
            getEntity();
        }
    }

    public void afterSave() {

    }

    public void beforeDelete() {

    }

    public String delete(E e) {
        try {
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

    public boolean isUpdate() {
        return this.entityId != null;
    }

    public void setUpdate(boolean update) {
        isUpdate = update;
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
}
