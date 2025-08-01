/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filters;

import jakarta.inject.Inject;
import jakarta.security.enterprise.SecurityContext;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import service.interfaces.PermissionServiceLocal;
import service.interfaces.UserServiceLocal;

/**
 *
 * @author steph18
 */

public class PermissionFilter  {

    @Inject
    private SecurityContext securityContext;

    @Inject
    private PermissionServiceLocal permissionService;

    @Inject
    private UserServiceLocal userService;

//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest request = (HttpServletRequest) req;
//        String path = request.getRequestURI();
//
//        String permissionCode = permissionService.findPermissionCodeByPath(path);
//
//        if (permissionCode != null && !userService.hasPermission(securityContext.getCallerPrincipal().getName(), permissionCode)) {
//            ((HttpServletResponse) res).sendError(HttpServletResponse.SC_FORBIDDEN);
//            return;
//        }
//
//        chain.doFilter(req, res);
//    }
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        String path = request.getRequestURI();
//
//        //String permissionCode = permissionService.getByCode(path);
//        String permissionCode;
//
//        if (permissionCode != null && !userService.hasPermission(securityContext.getCallerPrincipal().getName(), permissionCode)) {
//            ((HttpServletResponse) res).sendError(HttpServletResponse.SC_FORBIDDEN);
//            return;
//        }
//
//        chain.doFilter(req, res);
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//    }

//    @Override
//    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
//    }
}
