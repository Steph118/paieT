package bean;

import entities.Role;
import entities.User;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import service.interfaces.GenericServiceLocal;
import service.interfaces.UserServiceLocal;

import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class UserBean extends GenericBean<User,Integer> {

    @EJB
    private UserServiceLocal userService;

    private String confirmPassword;
    private List<Role> roles = new ArrayList<>();

    @Override
    public GenericServiceLocal<User, Integer> getService() {
        return userService;
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
}
