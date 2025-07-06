package bean;

import entities.Role;
import entities.User;
import exception.BusinessException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import service.interfaces.GenericServiceLocal;
import service.interfaces.UserServiceLocal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.omnifaces.util.Messages;
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

    public String changePassword() {
        try {
            this.logger.log(Level.INFO, "changePassword...");
            this.userService.updateWithPassword(this.getEntity());
            this.logger.log(Level.INFO, "Changement de mot de passe effectué: {0}", this.entity);
            Messages.addFlashGlobalInfo("Changement de mot de passe effectuée avec succès.");
        } catch (BusinessException ex) {
            Messages.addFlashGlobalError(ex.getMessage());
            this.logger.log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            Messages.addFlashGlobalError("Une erreur est survenue lors de la modification.");
            this.logger.log(Level.SEVERE, ex, () -> "Erreur à la modification de l'objet: " + ex);
        }
        return cancel();
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
