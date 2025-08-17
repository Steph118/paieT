package bean;

import entities.User;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.SecurityContext;
import service.interfaces.UserServiceLocal;
import utils.PermsConstant;

import java.io.Serializable;
import java.util.Set;

@Named
@SessionScoped
public class SessionBean implements Serializable {

    @Inject
    private UserServiceLocal userService;
    private final SecurityContext security;
    private User currentUser;

    public SessionBean() {
        security = CDI.current().select(SecurityContext.class).get();
    }
    @PostConstruct
    public void init() {
        currentUser = userService.findByUsername(security.getCallerPrincipal().getName()).orElse(null);
        System.err.println("user : " + currentUser);
    }

    public boolean hasAccessToWebRessource(String resource, String method) {
        return this.security.hasAccessToWebResource(resource, method);
    }

    public boolean isCallerInPermission(String role) {
        return this.security.isCallerInRole(role);
    }

    public boolean isCallerInPermission(String... roles) {
        for (String r : roles) {
            if (this.security.isCallerInRole(r)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInAllPermission(String... roles) {
        for (String r : roles) {
            if (!this.security.isCallerInRole(r)) {
                return false;
            }
        }
        return true;
    }

    public Set<String> permissions() {
        return this.security.getAllDeclaredCallerRoles();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    boolean filterPermission(String...r) {
        if (this.security.isCallerInRole(PermsConstant.ALL)) {
            return true;
        }
        return isCallerInPermission(r);
    }

}
