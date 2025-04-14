package com.mycompany.managementdashboard.servlet;

import com.mycompany.managementdashboard.model.Student;
import com.mycompany.managementdashboard.model.Teacher;
import com.mycompany.managementdashboard.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            Student student = new Student();
            student.setUsername(request.getParameter("username"));
            student.setFname(request.getParameter("fname"));
            student.setLname(request.getParameter("lname"));
            student.setEmail(request.getParameter("email"));
            student.setPassword(request.getParameter("password"));

            studentService.registerStudent(student);
            response.sendRedirect("login.jsp");
        } else if ("login".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Student loggedInStudent = studentService.login(username, password);

            if (loggedInStudent != null) {
                HttpSession session = request.getSession();
                session.setAttribute("student", loggedInStudent);
                response.sendRedirect("studentDashboard.jsp");
            } else {
                response.sendRedirect("login.jsp?error=1");
            }
        }else if ("update".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("studentId"));

                Student student = studentService.getStudentById(id);
                if (student != null) {
                    student.setUsername(request.getParameter("username"));
                    student.setFname(request.getParameter("fname"));
                    student.setLname(request.getParameter("lname"));
                    student.setEmail(request.getParameter("email"));
                    student.setPassword(request.getParameter("password"));

                    studentService.updateStudent(student);
                    response.sendRedirect("adminDashboard.jsp?success=StudentUpdated");
                } else {
                    response.sendRedirect("adminDashboard.jsp?error=StudentNotFound");
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("adminDashboard.jsp?error=InvalidStudentId");
            }
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            try {
                int studentId = Integer.parseInt(request.getParameter("id"));
                studentService.deleteStudent(studentId);
                response.sendRedirect("adminDashboard.jsp?success=StudentDeleted");
            } catch (NumberFormatException e) {
                response.sendRedirect("adminDashboard.jsp?error=InvalidStudentId");
            }
        } else if ("list".equals(action)) {
            List<Student> students = studentService.getAllStudents();
            request.setAttribute("students", students);
            request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
        }
    }
}
