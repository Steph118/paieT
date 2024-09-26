package bean;

import classutils.UserPrincipal;
import entities.User;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.CallerPrincipal;
import jakarta.security.enterprise.SecurityContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.Serializable;
import java.util.Optional;

@Named
@SessionScoped
public class SessionBean implements Serializable {

    @Inject
    private HttpServletRequest request;

    @Inject
    private SecurityContext securityContext;

    private final User user = this.securityContext.getPrincipalsByType(UserPrincipal.class)
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

}
