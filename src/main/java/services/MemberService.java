/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.MemberDao;
import dao.RepositoryDao;
import entities.Eglise;
import entities.Member;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;
import service.interfaces.MemberServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class MemberService extends GenericServiceLocalImpl<Member, Integer>
        implements MemberServiceLocal {

    @EJB
    private MemberDao dao;

    @Override
    protected RepositoryDao<Member, Integer> getDAO() {
        return dao;
    }

    @Override
    public Long countMemberByCurch(Eglise e) {
        return this.dao.countMemberByCurch(e);
    }

    @Override
    public void saveAll(List<Member> es) {
        for (Member m : es) {
            System.err.println("inum ==>  " + this.dao.genererNumeroMembre(m.getEglise()));
            m.setMemberNumber(this.dao.genererNumeroMembre(m.getEglise()));
            this.save(m);
        }
    }

    @Override
    public Member update(Member e) {
        System.err.println("inum ==>  " + this.dao.genererNumeroMembre(e.getEglise()));
        e.setMemberNumber(this.dao.genererNumeroMembre(e.getEglise()));
        return this.dao.update(e);
    }

}
