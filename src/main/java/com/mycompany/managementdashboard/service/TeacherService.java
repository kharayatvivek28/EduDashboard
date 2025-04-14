package com.mycompany.managementdashboard.service;

import com.mycompany.managementdashboard.DAO.TeacherDAO;
import com.mycompany.managementdashboard.model.Teacher;

import java.util.List;

public class TeacherService {
    private final TeacherDAO teacherDAO = new TeacherDAO();

    public void registerTeacher(Teacher teacher) {
        teacherDAO.saveTeacher(teacher);
    }

    public Teacher login(String username, String password) {
        return teacherDAO.getTeacherByUsernameAndPassword(username, password);
    }
    public List<Teacher> getAllTeachers() {
        return TeacherDAO.getAllTeachers();
    }

    public void deleteTeacher(int id) {
        teacherDAO.deleteTeacher(id);
    }
    public Teacher getTeacherById(int id) {
        return TeacherDAO.getTeacherById(id);
    }
    public void updateTeacher(Teacher teacher) {
        teacherDAO.updateTeacher(teacher);
    }
    public Teacher getTeacherWithDetailsById(int teacherId) {
        TeacherDAO teacherDAO = new TeacherDAO();
        return teacherDAO.getTeacherWithDetailsById(teacherId);
    }





}
