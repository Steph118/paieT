package bean;

import entities.Role;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import service.interfaces.GenericServiceLocal;
import service.interfaces.RoleServiceLocal;

@Named
@ViewScoped
public class RoleBean extends GenericBean<Role,Integer>{

    @EJB
    private RoleServiceLocal roleService;

    @Override
    public GenericServiceLocal<Role, Integer> getService() {
        return roleService;
    }

    @Override
    public void initAdd() {
        this.entity = new Role();
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
