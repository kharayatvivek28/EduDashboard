package com.mycompany.managementdashboard.servlet;

import com.mycompany.managementdashboard.model.Admin;
import com.mycompany.managementdashboard.service.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private final AdminService adminService = new AdminService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            Admin admin = new Admin();
            admin.setUsername(request.getParameter("username"));
            admin.setFname(request.getParameter("fname"));
            admin.setLname(request.getParameter("lname"));
            admin.setEmail(request.getParameter("email"));
            admin.setPassword(request.getParameter("password"));

            adminService.registerAdmin(admin);
            response.sendRedirect("login.jsp");

        } else if ("login".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Admin loggedInAdmin = adminService.login(username, password);

            if (loggedInAdmin != null) {
                HttpSession session = request.getSession();
                session.setAttribute("admin", loggedInAdmin);
                response.sendRedirect("adminDashboard.jsp");
            } else {
                response.sendRedirect("login.jsp?error=1");
            }

        } else if ("update".equals(action)) {
            int adminId = Integer.parseInt(request.getParameter("adminId"));

            Admin admin = new Admin();
            admin.setAdminId(adminId);
            admin.setUsername(request.getParameter("username"));
            admin.setFname(request.getParameter("fname"));
            admin.setLname(request.getParameter("lname"));
            admin.setEmail(request.getParameter("email"));
            admin.setPassword(request.getParameter("password"));

            adminService.updateAdmin(admin);
            response.sendRedirect("adminDashboard.jsp?success=AdminUpdated");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            try {
                int adminId = Integer.parseInt(request.getParameter("id"));
                adminService.deleteAdmin(adminId);
                response.sendRedirect("adminDashboard.jsp?success=AdminDeleted");
            } catch (NumberFormatException e) {
                response.sendRedirect("adminDashboard.jsp?error=InvalidAdminId");
            }
        }
    }
}
