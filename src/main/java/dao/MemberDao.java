/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Department;
import entities.Eglise;
import entities.Locality;
import entities.Member;
import entities.Person;
import jakarta.ejb.Stateless;
import java.util.List;

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

    public int updateEglise(Person p, Integer num) {
        return this.em.createQuery("""
                            UPDATE Member m SET 
                            m.eglise = :e , 
                            m.memberNumber = :num
                            WHERE m.person = :p 
                            """)
                .setParameter("e", p.getEglise())
                .setParameter("num", num)
                .setParameter("p", p)
                .executeUpdate();
    }

    public List<Member> getByEgliseAndDptmnt(Eglise eglise, Department dptmnt) {
        String jpql = """ 
                      SELECT e FROM Member e WHERE e.eglise = :eglise AND e.person.department = :dptmnt
                      """;
        return this.em.createQuery(jpql)
                .setParameter("eglise", eglise)
                .setParameter("dptmnt", dptmnt)
                .getResultList();
    }
}
