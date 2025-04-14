package com.mycompany.managementdashboard.servlet;

import com.mycompany.managementdashboard.model.Teacher;
import com.mycompany.managementdashboard.service.TeacherService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
    private final TeacherService teacherService = new TeacherService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            Teacher teacher = new Teacher();
            teacher.setUsername(request.getParameter("username"));
            teacher.setFname(request.getParameter("fname"));
            teacher.setLname(request.getParameter("lname"));
            teacher.setEmail(request.getParameter("email"));
            teacher.setPassword(request.getParameter("password"));

            teacherService.registerTeacher(teacher);
            response.sendRedirect("login.jsp");

        } else if ("login".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Teacher loggedInTeacher = teacherService.login(username, password);

            if (loggedInTeacher != null) {
                HttpSession session = request.getSession();
                session.setAttribute("teacher", loggedInTeacher);
                response.sendRedirect("teacherDashboard.jsp");
            } else {
                response.sendRedirect("login.jsp?error=1");
            }

        } else if ("update".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("teacherId"));

                Teacher teacher = teacherService.getTeacherById(id);
                if (teacher != null) {
                    teacher.setUsername(request.getParameter("username"));
                    teacher.setFname(request.getParameter("fname"));
                    teacher.setLname(request.getParameter("lname"));
                    teacher.setEmail(request.getParameter("email"));
                    teacher.setPassword(request.getParameter("password"));

                    teacherService.updateTeacher(teacher);
                    response.sendRedirect("adminDashboard.jsp?success=TeacherUpdated");
                } else {
                    response.sendRedirect("adminDashboard.jsp?error=TeacherNotFound");
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("adminDashboard.jsp?error=InvalidTeacherId");
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            try {
                int teacherId = Integer.parseInt(request.getParameter("id"));
                teacherService.deleteTeacher(teacherId);
                response.sendRedirect("adminDashboard.jsp?success=TeacherDeleted");
            } catch (NumberFormatException e) {
                response.sendRedirect("adminDashboard.jsp?error=InvalidTeacherId");
            }
        } else if ("list".equals(action)) {
            List<Teacher> teachers = teacherService.getAllTeachers();
            request.setAttribute("teachers", teachers);
            request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
        }
    }
    }

