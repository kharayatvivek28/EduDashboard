package com.mycompany.managementdashboard.servlet;

import com.mycompany.managementdashboard.model.Teacher;
import com.mycompany.managementdashboard.model.TeacherDetails;
import com.mycompany.managementdashboard.service.TeacherDetailsService;
import com.mycompany.managementdashboard.service.TeacherService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/teacherDetails")
public class TeacherDetailsServlet extends HttpServlet {

    private final TeacherDetailsService teacherDetailsService = new TeacherDetailsService();
    private final TeacherService teacherService = new TeacherService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addDetails".equals(action)) {
            int teacherId = Integer.parseInt(request.getParameter("teacherId"));

            // Fetch the teacher by ID
            Teacher teacher = teacherService.getTeacherById(teacherId);
            if (teacher == null) {
                response.sendRedirect("adminDashboard.jsp?error=TeacherNotFound");
                return;
            }

            // Collect biodata from form
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            int age = Integer.parseInt(request.getParameter("age"));
            double salary = Double.parseDouble(request.getParameter("salary"));
            String role = request.getParameter("role");
            String expertisedSubjects = request.getParameter("expertisedSubjects");

            // Create and populate TeacherDetails object
            TeacherDetails details = new TeacherDetails();
            details.setAddress(address);
            details.setPhone(phone);
            details.setAge(age);
            details.setSalary(salary);
            details.setRole(role);
            details.setExpertisedSubjects(expertisedSubjects);
            details.setTeacher(teacher);  // establish relation

            // Save using service
            teacherDetailsService.addTeacherDetails(details);

            response.sendRedirect("adminDashboard.jsp?success=TeacherDetailsAdded");
        }
    }
}
