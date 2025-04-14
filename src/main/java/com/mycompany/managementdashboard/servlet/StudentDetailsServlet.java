package com.mycompany.managementdashboard.servlet;

import com.mycompany.managementdashboard.model.Student;
import com.mycompany.managementdashboard.model.StudentDetails;
import com.mycompany.managementdashboard.service.StudentDetailsService;
import com.mycompany.managementdashboard.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/StudentDetailsServlet")
public class StudentDetailsServlet extends HttpServlet {

    private final StudentDetailsService studentDetailsService = new StudentDetailsService();
    private final StudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addDetails".equals(action)) {
            int studentId = Integer.parseInt(request.getParameter("studentId"));

            // Fetch the student by ID
            Student student = studentService.getStudentById(studentId);
            if (student == null) {
                response.sendRedirect("adminDashboard.jsp?error=StudentNotFound");
                return;
            }

            // Collect details from form
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            int age = Integer.parseInt(request.getParameter("age"));
            String studentClass = request.getParameter("studentClass");
            String course = request.getParameter("course");

            // Create and populate StudentDetails object
            StudentDetails details = new StudentDetails();
            details.setAddress(address);
            details.setPhone(phone);
            details.setAge(age);
            details.setClassName(studentClass);
            details.setCourse(course);
            details.setStudent(student); // establish relationship

            // Save using service
            studentDetailsService.addStudentDetails(details);

            response.sendRedirect("adminDashboard.jsp?success=StudentDetailsAdded");
        }
    }
}
