/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.Member;
import entities.MonthEntity;
import entities.SumPaid;
import entities.SumPromised;
import jakarta.ejb.Local;
import java.math.BigDecimal;

/**
 * @author steph18
 */
@Local
public interface SumPaidServiceLocal extends GenericServiceLocal<SumPaid, Integer> {

    SumPaid findSumPaidBy(MonthEntity month, SumPromised sumPromised, Member member);

    BigDecimal totalSumPaid(SumPaid sp);
}
