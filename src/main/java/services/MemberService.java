/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.MemberDao;
import dao.RepositoryDao;
import entities.Member;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
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

}
