/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.Department;
import entities.Eglise;
import entities.Member;
import entities.Person;
import jakarta.ejb.Local;
import java.util.List;

/**
 * @author steph18
 */
@Local
public interface MemberServiceLocal extends GenericServiceLocal<Member, Integer> {

    Long countMemberByCurch(Eglise e);

    Integer genererNumeroMembre(Member m);

    Integer genererNumeroMembre(Eglise e);

    int updateEglise(Person p, Integer num);

    List<Member> getByEgliseAndDptmnt(Eglise e, Department d);
}
