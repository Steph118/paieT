package bean;

import entities.Role;
import entities.User;
import enumeration.EmailProvider;
import exception.BusinessException;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.apache.commons.lang3.StringUtils;
import org.omnifaces.util.Messages;
import service.interfaces.GenericServiceLocal;
import service.interfaces.PersonServiceLocal;
import service.interfaces.RoleServiceLocal;
import service.interfaces.UserServiceLocal;
import services.MailSenderService;
import utils.PermsConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

@Named
@ViewScoped
public class UserBean extends GenericBean<User, Integer> {

    @Inject
    private UserServiceLocal userService;
    @Inject
    protected SessionBean sessionBean;
    @Inject
    private RoleServiceLocal roleService;

    @Inject
    private MailSenderService mailSenderService;

    @EJB
    private PersonServiceLocal personService;

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

    public void sendPasswordByMail() {
        try {
            personService.findByUser(this.entity)
                    .ifPresentOrElse((p) -> {
                                if (StringUtils.isNotEmpty(p.getMail())) {
                                    this.mailSenderService.sendMail(EmailProvider.GMAIL,
                                            p.getMail(),
                                            "MOT DE PASSE DE CONNEXION",
                                            "reset-password.html",
                                            null);
                                    Messages.addFlashGlobalInfo(
                                            """
                                                    Mise à jour effectuée avec succès. 
                                                    Un mail est envoyé sur l'adresse : 
                                                    """);
                                    this.cancel();
                                    return;
                                }
                                Messages.addFlashGlobalInfo("Vous ne pouvez pas envoyé de mail pour cet utilisateur");
                            },
                            () -> {
                                Messages.addFlashGlobalError("Une erreur est survenue!");
                            }
                    );

        } catch (Exception e) {
            Messages.addFlashGlobalError("Erreur inattendue!");
            this.logger.log(Level.SEVERE, "sendPasswordByMail", e);
        }

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
        return sessionBean.filterPermission(PermsConstant.USER_ALL, PermsConstant.USER_ADD);
    }

    @Override
    public boolean canDelete() {
        return sessionBean.filterPermission(PermsConstant.USER_ALL, PermsConstant.USER_DELETE);
    }

    @Override
    public boolean canDetails() {
        return sessionBean.filterPermission(PermsConstant.USER_ALL, PermsConstant.USER_DETAILS);
    }

    public boolean canChangePassword() {
        return sessionBean.filterPermission(PermsConstant.USER_ALL, PermsConstant.USER_CHANGE_PWD);
    }

    @Override
    public boolean canUpdate() {
        return sessionBean.filterPermission(PermsConstant.USER_ALL, PermsConstant.USER_EDIT);
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
