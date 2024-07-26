/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.Member;
import entities.Person;
import jakarta.ejb.Local;

/**
 * @author steph18
 */
@Local
public interface MemberServiceLocal extends GenericServiceLocal<Member, Integer> {
}
