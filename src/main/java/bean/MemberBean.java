/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Member;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import service.interfaces.GenericServiceLocal;
import service.interfaces.MemberServiceLocal;

/**
 * @author steph18
 */
@Named
@ViewScoped
public class MemberBean extends GenericBean<Member, Integer> {

    @EJB
    private MemberServiceLocal memberService;

    @Override
    public GenericServiceLocal<Member, Integer> getService() {
        return memberService;
    }

    @Override
    public void initAdd() {
        this.entity = new Member();
    }

    @Override
    public boolean canAdd() {
        return true;
    }

    @Override
    public boolean canDelete() {
        return true;
    }

    @Override
    public boolean canDetails() {
        return true;
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

}
