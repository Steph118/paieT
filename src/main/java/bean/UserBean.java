package bean;

import entities.Eglise;
import entities.Role;
import entities.User;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import service.interfaces.GenericServiceLocal;
import service.interfaces.UserServiceLocal;

import java.util.ArrayList;
import java.util.List;
import service.interfaces.EgliseServiceLocal;
import service.interfaces.RoleServiceLocal;

@Named
@ViewScoped
public class UserBean extends GenericBean<User, Integer> {

    @EJB
    private UserServiceLocal userService;

    @EJB
    private RoleServiceLocal roleService;

    private String confirmPassword;
    private boolean userActif;
    private List<Role> roles = new ArrayList<>();

    @Override
    public GenericServiceLocal<User, Integer> getService() {
        return userService;
    }

    @Override
    public void initEntity() {
        super.initEntity();
        this.roles = roleService.getAll();
    }

    @Override
    public void initAdd() {
        this.entity = new User();
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean isUserActif() {
        return userActif;
    }

    public void setUserActif(boolean userActif) {
        this.userActif = userActif;
    }
}
