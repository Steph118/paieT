/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.Eglise;
import entities.Loan;
import jakarta.ejb.Local;
import java.util.List;

/**
 * @author steph18
 */
@Local
public interface LoanServiceLocal extends GenericServiceLocal<Loan, Integer> {

    public List<Loan> getLoansByEglise(Eglise eglise);
}
