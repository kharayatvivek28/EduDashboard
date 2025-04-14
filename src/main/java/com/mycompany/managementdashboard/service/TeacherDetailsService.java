package com.mycompany.managementdashboard.service;

import com.mycompany.managementdashboard.DAO.TeacherDetailsDAO;
import com.mycompany.managementdashboard.model.Teacher;
import com.mycompany.managementdashboard.model.TeacherDetails;
import com.mycompany.managementdashboard.DAO.TeacherDAO;

import java.util.List;

public class TeacherDetailsService {
    private final TeacherDetailsDAO teacherDetailsDAO = new TeacherDetailsDAO();

    public void addTeacherDetails(TeacherDetails details) {
        teacherDetailsDAO.saveTeacherDetails(details);
    }

    public void updateTeacherDetails(TeacherDetails details) {
        teacherDetailsDAO.updateTeacherDetails(details);
    }

    public TeacherDetails getTeacherDetailsById(int id) {
        return teacherDetailsDAO.getTeacherDetailsById(id);
    }

    public void deleteTeacherDetails(TeacherDetails details) {
        teacherDetailsDAO.deleteTeacherDetails(details);
    }
    public Teacher getTeacherById(int id) {
        return TeacherDAO.getTeacherById(id);
    }
    public List<Teacher> getAllTeachers() {
        return TeacherDAO.getAllTeachers();  // this will return teachers with attached TeacherDetails (because of @OneToOne)
    }


}
