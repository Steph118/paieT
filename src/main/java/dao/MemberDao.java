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

}
