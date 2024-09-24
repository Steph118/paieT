package bean;

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
import jakarta.validation.constraints.NotNull;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@RequestScoped
public class AuthenticationBean implements Serializable {

    @NotNull
    private String username;

    @NotNull
    private String password;

    private boolean rememberMe;

    @Inject
    private FacesContext facesContext;

    @Inject
    private ExternalContext externalContext;

    @Inject
    private SecurityContext securityContext;

    public void login() {
        switch (continueAuthentication()) {
            case SEND_CONTINUE ->
                facesContext.responseComplete();
            case SEND_FAILURE ->
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed", null));
            case SUCCESS -> {
                try {
                    facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Login succeed", null));
                    if (rememberMe) {
                        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
                        request.setAttribute("jakarta.security.enterprise.authentication.mechanism.http.rememberMe", true);
                    }
                    externalContext.redirect(externalContext.getRequestContextPath() + "/index.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(AuthenticationBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case NOT_DONE ->
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "NOT DONE", null));
        }
    }

    private AuthenticationStatus continueAuthentication() {
        return securityContext.authenticate(
                (HttpServletRequest) externalContext.getRequest(),
                (HttpServletResponse) externalContext.getResponse(),
                AuthenticationParameters.withParams()
                        .newAuthentication(true)
                        .credential(new UsernamePasswordCredential(username, password)));
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
