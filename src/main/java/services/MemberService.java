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
        return this.dao.countMemberByCurch(e.getId());
    }

    @Override
    public void saveAll(List<Member> es) {
        for (Member m : es) {
            int i = this.countMemberByCurch(m.getEglise()).intValue();
            System.err.println("num : " + (int) i++);
            m.setMemberNumber(i++);
            this.save(m);
            System.err.println("m : " + m);
        }
    }

}
