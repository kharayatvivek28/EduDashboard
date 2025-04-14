package com.mycompany.managementdashboard.DAO;

import com.mycompany.managementdashboard.HibernateUtil.HibernateUtil;
import com.mycompany.managementdashboard.model.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdminDAO {

    // Save new admin
    public void saveAdmin(Admin admin) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession(); // open session
            tx = session.beginTransaction();

            System.out.println("Saving admin: " + admin.getFname() + " " + admin.getLname());
            session.save(admin);  // Save admin to the database
            tx.commit();  // Commit the transaction

            System.out.println("Teacher saved successfully with ID: " + admin.getAdminId());
        } catch (Exception e) {
            if (tx != null) {
                try {
                    tx.rollback(); // rollback only if active
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("Error saving admin: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close(); // always close the session!
            }
        }
    }

    // Update existing admin
    public void updateAdmin(Admin admin) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(admin);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // Delete admin by ID
    public void deleteAdmin(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Admin admin = session.get(Admin.class, id);
            if (admin != null) {
                session.delete(admin);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // Get admin by ID
    public Admin getAdminById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Admin.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get admin by username and password
    public Admin getAdminByUsernameAndPassword(String username, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "FROM Admin WHERE username = :username AND password = :password", Admin.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get all admins
    public static List<Admin> getAllAdmins() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Admin", Admin.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
