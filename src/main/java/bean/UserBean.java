package bean;

import entities.Role;
import entities.User;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import service.interfaces.GenericServiceLocal;
import service.interfaces.UserServiceLocal;

import java.util.ArrayList;
import java.util.List;
import service.interfaces.RoleServiceLocal;

@Named
@ViewScoped
public class UserBean extends GenericBean<User, Integer> {

    @Inject
    private UserServiceLocal userService;

    @Inject
    private RoleServiceLocal roleService;

    private String confirmPassword;
    private List<Role> roles = new ArrayList<>();

    @Override
    public GenericServiceLocal<User, Integer> getService() {
        return userService;
    }

    @Override
    public void beforeSave() {
        this.entity.setRoles(this.getRoles());
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

}
