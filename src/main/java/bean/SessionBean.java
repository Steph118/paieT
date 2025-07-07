package bean;

import utils.UserPrincipal;
import entities.User;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.SecurityContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.Serializable;

@Named
@SessionScoped
public class SessionBean implements Serializable {

    @Inject
    private HttpServletRequest request;

    @Inject
    private SecurityContext security;

    private final User user = this.security.getPrincipalsByType(UserPrincipal.class)
            .stream()
            .map(e -> e.getUser())
            .findAny()
            .get();

    public HttpSession getSession() {
        return this.request.getSession();
    }

    public User getUser() {
        return user;
    }

    public boolean hasAccessToWebRessource(String resource, String method) {
        return this.security.hasAccessToWebResource(resource, method);
    }

    public boolean isCallerInRole(String role) {
        return this.security.isCallerInRole(role);
    }

    public boolean isUserInRole(String role) {
        return this.request.isUserInRole(role);
    }

}
