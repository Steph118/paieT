/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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

    public Long countMemberByCurch(Integer egliseId) {
        return this.em.createQuery("SELECT COUNT(m) FROM Member m WHERE m.eglise.id = :egliseId", Long.class)
                .setParameter("egliseId", egliseId)
                .getSingleResult();

    }

}
