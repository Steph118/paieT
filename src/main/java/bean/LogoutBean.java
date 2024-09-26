package bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.Serializable;

@Named
@RequestScoped
public class LogoutBean {
    @Inject
    private HttpServletRequest request;

    @Inject
    private ExternalContext externalContext;

    public void submit() throws ServletException, IOException {
        request.logout();
        request.getSession().invalidate();
        externalContext.redirect(externalContext.getRequestContextPath() + "/login.xhtml");
    }
}