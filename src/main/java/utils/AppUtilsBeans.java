/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 *
 * @author steph18
 */
@Named
@ViewScoped
public class AppUtilsBeans implements Serializable {
    public String numberFormat(BigDecimal montant) {
        return AppUtils.formatNumber(montant);
    }
}
