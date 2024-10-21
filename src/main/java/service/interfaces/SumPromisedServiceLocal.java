/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.Loan;
import entities.Member;
import entities.SumPromised;
import entities.Year;
import jakarta.ejb.Local;

/**
 * @author steph18
 */
@Local
public interface SumPromisedServiceLocal extends GenericServiceLocal<SumPromised, Integer> {

    SumPromised findBy(Member member, Loan loan, Year year);
}
