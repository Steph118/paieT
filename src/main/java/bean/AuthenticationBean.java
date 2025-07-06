package bean;

import entities.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotEmpty;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.interfaces.UserServiceLocal;

@Named
@RequestScoped
public class AuthenticationBean implements Serializable {

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
//        System.err.println("LoadDatabase");
//        User u = userService.findByUsername("admin");
//        u.setPassword("toto");
//        userService.update(u);
        switch (continueAuthentication()) {
            case SEND_CONTINUE ->
                facesContext.responseComplete();
            case SEND_FAILURE ->
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed", null));
            case SUCCESS -> {
                try {
//                    User u = this.userService.findByUsername(this.getUsername());
//                    if (u == null) {
//                        this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur survenu lors de la connexion", null));
//                        return;
//                    }
//                    if (!u.getActif()) {
//                        this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Utlisateur desactive", null));
//                        return;
//                    }
//                    if (u.getChangePassword()) {
//                        this.externalContext.redirect(externalContext.getRequestContextPath() + "/forget-password.xhtml");
//return;
//                    }
                    if (this.rememberMe) {
                        HttpServletRequest request = (HttpServletRequest) this.externalContext.getRequest();
                        request.setAttribute("jakarta.security.enterprise.authentication.mechanism.http.rememberMe", true);
                    }
                    this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Login succeed", null));
                    this.externalContext.redirect(this.externalContext.getRequestContextPath() + "/index.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(AuthenticationBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case NOT_DONE ->
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "NOT DONE", null));
        }
    }

    private AuthenticationStatus continueAuthentication() {
        return this.securityContext.authenticate(
                (HttpServletRequest) this.externalContext.getRequest(),
                (HttpServletResponse) this.externalContext.getResponse(),
                AuthenticationParameters.withParams()
                        .newAuthentication(true)
                        .credential(new UsernamePasswordCredential(this.getUsername(), this.getPassword())));
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
