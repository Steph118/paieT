/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.EmailConfig;
import enumeration.EmailProvider;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import service.interfaces.EmailConfigServiceLocal;
import service.interfaces.GenericServiceLocal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class EmailConfigBean extends GenericBean<EmailConfig, Long> {

    @Inject
    private EmailConfigServiceLocal emailConfigService;

    private List<EmailProvider> providers = new ArrayList<>();

    @Override
    public GenericServiceLocal<EmailConfig, Long> getService() {
        return emailConfigService;
    }

    @Override
    public void initEntity() {
        super.initEntity();
        this.providers = EmailProvider.getListProvider();
    }

    @Override
    public void initAdd() {
        this.entity = new EmailConfig();
    }

    @Override
    public boolean canAdd() {
        return true;
    }

    @Override
    public boolean canDelete() {
        return true;
    }

    @Override
    public boolean canDetails() {
        return true;
    }

    @Override
    public String save() {
        return super.save();
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    public List<EmailProvider> getProviders() {
        return providers;
    }

}
