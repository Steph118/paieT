/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filters;

import jakarta.annotation.security.RolesAllowed;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 *
 * @author steph18
 */
//WebServlet("/paie/pages/*")
//@RolesAllowed("architect")
public class PermissionFilter extends HttpServlet {

    @RolesAllowed("admin")
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

    }

    @RolesAllowed("admzinn")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
    }

    @RolesAllowed("admindn")
    @Override
    protected void doTrace(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
    }

}
