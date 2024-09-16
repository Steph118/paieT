/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.MemberDao;
import dao.RepositoryDao;
import entities.Department;
import entities.Eglise;
import entities.Member;
import entities.Person;
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
            m.setMemberNumber(this.genererNumeroMembre(m));
            this.save(m);
        }
    }

    @Override
    public void save(Member e) {
        e.setMemberNumber(this.genererNumeroMembre(e));
        this.dao.save(e);
    }

    @Override
    public Integer genererNumeroMembre(Member m) {
        return this.dao.genererNumeroMembre(m.getEglise());
    }

    @Override
    public Integer genererNumeroMembre(Eglise e) {
        return this.dao.genererNumeroMembre(e);
    }

    @Override
    public int updateEglise(Person p, Integer num) {
        return this.dao.updateEglise(p, num);
    }

    @Override
    public List<Member> getByEgliseAndDptmnt(Eglise e, Department d) {
        return this.dao.getByEgliseAndDptmnt(e, d);
    }

}
