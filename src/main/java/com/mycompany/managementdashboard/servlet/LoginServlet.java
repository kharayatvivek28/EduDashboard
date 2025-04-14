package com.mycompany.managementdashboard.servlet;

import com.mycompany.managementdashboard.model.*;
import com.mycompany.managementdashboard.service.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private final AdminService adminService = new AdminService();
    private final TeacherService teacherService = new TeacherService();
    private final StudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        switch (role) {
            case "admin":
                Admin admin = adminService.login(username, password);
                if (admin != null) {
                    session.setAttribute("admin", admin);
                    response.sendRedirect("adminDashboard.jsp");
                } else {
                    response.sendRedirect("login.jsp?error=true");
                }
                break;

            case "teacher":
                Teacher teacher = teacherService.login(username, password);
                if (teacher != null) {
                    session.setAttribute("teacher", teacher);
                    response.sendRedirect("teacherDashboard.jsp");
                } else {
                    response.sendRedirect("login.jsp?error=true");
                }
                break;

            case "student":
                Student student = studentService.login(username, password);
                if (student != null) {
                    session.setAttribute("student", student);
                    response.sendRedirect("studentDashboard.jsp");
                } else {
                    response.sendRedirect("login.jsp?error=true");
                }
                break;

            default:
                response.sendRedirect("login.jsp?error=invalid_role");
                break;
        }
    }
}
