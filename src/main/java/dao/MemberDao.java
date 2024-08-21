/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Eglise;
import entities.Member;
import jakarta.ejb.Stateless;

/**
 * @author steph18
 */
@Stateless
public class MemberDao extends RepositoryDao<Member, Integer> {

    public MemberDao() {
        super(Member.class);
    }

    public Long countMemberByCurch(Eglise eglise) {
        return this.em.createQuery("SELECT COUNT(m) FROM Member m WHERE m.eglise = :eglise", Long.class)
                .setParameter("eglise", eglise)
                .getSingleResult();

    }

    public Integer genererNumeroMembre(Eglise eglise) {
        Integer nextNumero = this.em.createQuery(
                "SELECT ( MAX(m.memberNumber) + 1 ) FROM Member m WHERE m.eglise = :eglise", Integer.class)
                .setParameter("eglise", eglise)
                .getSingleResult();
        if (nextNumero == null) {
            nextNumero = 1;
        }
        return nextNumero;
    }

}
