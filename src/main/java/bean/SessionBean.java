package bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.Serializable;

@Named
@SessionScoped
public class SessionBean implements Serializable {
    @Inject
    private HttpServletRequest request;

    public void submit() throws ServletException {
        this.request.logout();
        this.request.getSession().invalidate();
    }

    public void getSession() {
        HttpSession session = this.request.getSession();
    }
}
