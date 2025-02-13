/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classutils;

import jakarta.inject.Inject;
import jakarta.security.enterprise.SecurityContext;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import service.interfaces.UserServiceLocal;

/**
 *
 * @author mediasoft
 */
@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    @Inject
    private UserServiceLocal userService;

    @Inject
    private HttpServletRequest request;

    @Inject
    private SecurityContext securityContext;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        String path = httpRequest.getRequestURI();
        String method = httpRequest.getMethod();

        String username = securityContext.getCallerPrincipal().getName();
        if (this.userService.hasPermission(username, path, method)) {
            chain.doFilter(req, res);
        } else {
            ((HttpServletResponse) res).sendError(HttpServletResponse.SC_FORBIDDEN, "Accès interdit");
        }
    }
}
