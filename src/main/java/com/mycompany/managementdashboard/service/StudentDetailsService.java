package com.mycompany.managementdashboard.service;

import com.mycompany.managementdashboard.DAO.StudentDetailsDAO;
import com.mycompany.managementdashboard.DAO.StudentDAO;
import com.mycompany.managementdashboard.model.Student;
import com.mycompany.managementdashboard.model.StudentDetails;

import java.util.List;

public class StudentDetailsService {

    private final StudentDetailsDAO studentDetailsDAO = new StudentDetailsDAO();

    public void addStudentDetails(StudentDetails details) {
        studentDetailsDAO.saveStudentDetails(details);
    }

    public void updateStudentDetails(StudentDetails details) {
        studentDetailsDAO.updateStudentDetails(details);
    }

    public StudentDetails getStudentDetailsById(int id) {
        return studentDetailsDAO.getStudentDetailsById(id);
    }

    public void deleteStudentDetails(StudentDetails details) {
        studentDetailsDAO.deleteStudentDetails(details);
    }

    public Student getStudentById(int id) {
        return StudentDAO.getStudentById(id);
    }
    public List<Student> getAllStudents() {
        return StudentDetailsDAO.getAllStudents();
    }


}
