package bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.Password;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStoreHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;

@Named
@RequestScoped
public class AuthenticationBean {

    @Inject
    private IdentityStoreHandler identityStoreHandler;

    @NotNull
    private String username;

    @NotNull
    private String password;

    public void login() {
        FacesContext context = FacesContext.getCurrentInstance();
        Credential credential = new UsernamePasswordCredential(username, new Password(password));
        CredentialValidationResult cres = identityStoreHandler.validate(credential);

        if (cres.getStatus().equals(CredentialValidationResult.Status.VALID)) {
            context.responseComplete();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Authentication Successful", null));
        } else if (cres.getStatus().equals(CredentialValidationResult.Status.INVALID)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Authentication Failure", null));
        }
    }

    private static HttpServletResponse getResponse(FacesContext context) {
        return (HttpServletResponse) context.getExternalContext().getResponse();
    }

    private static HttpServletRequest getRequest(FacesContext context) {
        return (HttpServletRequest) context.getExternalContext().getRequest();
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
    
}
