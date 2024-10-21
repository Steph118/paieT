/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.Member;
import entities.SumPaid;
import entities.SumPromised;
import enumeration.Month;
import jakarta.ejb.Local;

/**
 * @author steph18
 */
@Local
public interface SumPaidServiceLocal extends GenericServiceLocal<SumPaid, Integer> {

    SumPaid findBy(Member member, SumPromised sumPromised, Month month);

}
