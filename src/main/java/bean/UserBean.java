package bean;

import entities.User;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import service.interfaces.GenericServiceLocal;
import service.interfaces.UserServiceLocal;
import services.UserService;

@Named
@ViewScoped
public class UserBean extends GenericBean<User,Integer> {

    @EJB
    private UserServiceLocal userService;

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
}
