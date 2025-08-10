package bean;

import entities.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.AuthenticationStatus;
import static jakarta.security.enterprise.AuthenticationStatus.NOT_DONE;
import static jakarta.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import static jakarta.security.enterprise.AuthenticationStatus.SEND_FAILURE;
import static jakarta.security.enterprise.AuthenticationStatus.SUCCESS;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotEmpty;
import service.interfaces.UserServiceLocal;

import java.io.IOException;
import java.io.Serializable;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.Subject;

@Named
@RequestScoped
public class LoginBean implements Serializable {

    @Inject
    private UserServiceLocal userService;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private boolean rememberMe;

    @Inject
    private FacesContext facesContext;

    @Inject
    private ExternalContext externalContext;

    @Inject
    private SecurityContext securityContext;

    public void login() {
        try {
            Optional<User> u = this.userService.findByUsername(this.getUsername());
            if (u.isEmpty() || !u.get().getActif()) {
                this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Utilisateur inconnu ou non actif", null));
                return;
            }
            if (!userService.isValidPassword(this.getPassword(), u.get().getPassword())) {
                this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mot de passe incorrect", null));
                return;
            }
            if (u.get().getChangePassword()) {
                this.externalContext.redirect(externalContext.getRequestContextPath() + "/paie/pages/app/forget-password.xhtml");
                return;
            }
            checkLogin(continueAuthentication(u.get().getId()));
        } catch (IOException e) {
            this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Erreur survenue", null));
        } catch (Exception e) {
            this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Erreur inattendue", null));
        }
    }

    private void checkLogin(AuthenticationStatus status) {
        switch (status) {
            case SEND_CONTINUE ->
                facesContext.responseComplete();
            case SEND_FAILURE -> {
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Login ou mot de passe incorrect", null));
            }
            case SUCCESS -> {
                try {
                    if (this.rememberMe) {
                        HttpServletRequest request = (HttpServletRequest) this.externalContext.getRequest();
                        request.setAttribute("jakarta.security.enterprise.authentication.mechanism.http.rememberMe", true);
                    }
                    this.externalContext.redirect(this.externalContext.getRequestContextPath() + "/index.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case NOT_DONE ->
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Une erreur est survenue", null));
        }
    }

    private AuthenticationStatus continueAuthentication(Integer id) {
        return this.securityContext.authenticate(
                (HttpServletRequest) this.externalContext.getRequest(),
                (HttpServletResponse) this.externalContext.getResponse(),
                AuthenticationParameters.withParams()
                        .newAuthentication(true)
                        .credential(new UsernamePasswordCredential(String.valueOf(id), this.getPassword())));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
