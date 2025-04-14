package com.mycompany.managementdashboard.service;

import com.mycompany.managementdashboard.DAO.StudentDAO;
import com.mycompany.managementdashboard.model.Student;


import java.util.List;

public class StudentService {
    private final StudentDAO studentDAO = new StudentDAO();

    public void registerStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    public Student login(String username, String password) {
        return studentDAO.getStudentByUsernameAndPassword(username, password);
    }

    public List<Student> getAllStudents() {
        return StudentDAO.getAllStudents();
    }
    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }
    public Student getStudentById(int id) {
        return StudentDAO.getStudentById(id);
    }
    public void updateStudent(Student student ) {
        studentDAO.updateStudent(student);
    }
    public Student getStudentWithDetailsById(int id) {
        return studentDAO.getStudentWithDetailsById(id);
    }

}
