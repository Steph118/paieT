/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.MonthEntity;
import entities.SumPromised;
import jakarta.ejb.Local;
import java.util.List;

/**
 * @author steph18
 */
@Local
public interface MonthServiceLocal extends GenericServiceLocal<MonthEntity, Integer> {

    List<MonthEntity> findMontNotPaid(SumPromised s);
}
