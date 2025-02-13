/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ResourceBundle;

/**
 *
 * @author steph18
 */
@Named
@SessionScoped
public class AppUtilsBeans implements Serializable {

    @Inject
    private FacesContext faces;

    public String numberFormat(BigDecimal montant) {
        return AppUtils.formatNumber(montant);
    }

    public String messageInterz(String key) {
        return ResourceBundle.getBundle(faces.getApplication().getMessageBundle(),
                faces.getViewRoot().getLocale()).getString(key);

    }
}
