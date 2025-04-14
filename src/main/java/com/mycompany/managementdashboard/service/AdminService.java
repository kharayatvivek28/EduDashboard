package com.mycompany.managementdashboard.service;

import com.mycompany.managementdashboard.DAO.AdminDAO;
import com.mycompany.managementdashboard.model.Admin;

import java.util.List;

public class AdminService {
    private final AdminDAO adminDAO = new AdminDAO();

    public void registerAdmin(Admin admin) {
        adminDAO.saveAdmin(admin);
    }

    public Admin login(String username, String password) {
        return adminDAO.getAdminByUsernameAndPassword(username, password);
    }

    public List<Admin> getAllAdmins() {
        return AdminDAO.getAllAdmins();
    }

    // ✅ New: Get Admin by ID
    public Admin getAdminById(int id) {
        return adminDAO.getAdminById(id);
    }

    // ✅ New: Update Admin
    public void updateAdmin(Admin admin) {
        adminDAO.updateAdmin(admin);
    }

    // ✅ New: Delete Admin
    public void deleteAdmin(int id) {
        adminDAO.deleteAdmin(id);
    }
}
