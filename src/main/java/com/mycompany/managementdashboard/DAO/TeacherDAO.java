package com.mycompany.managementdashboard.DAO;

import com.mycompany.managementdashboard.HibernateUtil.HibernateUtil;
import com.mycompany.managementdashboard.model.Teacher;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TeacherDAO {

    // Save a new teacher
    public void saveTeacher(Teacher teacher) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession(); // open session
            tx = session.beginTransaction();

            System.out.println("Saving teacher: " + teacher.getFname() + " " + teacher.getLname());
            session.save(teacher);  // Save teacher to the database
            tx.commit();  // Commit the transaction

            System.out.println("Teacher saved successfully with ID: " + teacher.getTeacherId());
        } catch (Exception e) {
            if (tx != null) {
                try {
                    tx.rollback(); // rollback only if active
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("Error saving teacher: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close(); // always close the session!
            }
        }
    }



    // Update an existing teacher
    public void updateTeacher(Teacher teacher) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(teacher);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }


    // Delete a teacher by ID
    public void deleteTeacher(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Teacher teacher = session.get(Teacher.class, id);
            if (teacher != null) {
                session.delete(teacher);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // Get a teacher by ID
    public static Teacher getTeacherById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Teacher.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get a teacher by username and password
    public Teacher getTeacherByUsernameAndPassword(String username, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Teacher WHERE username = :username AND password = :password", Teacher.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get all teachers
    public static List<Teacher> getAllTeachers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Teacher", Teacher.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Teacher getTeacherWithDetailsById(int teacherId) {
        Transaction transaction = null;
        Teacher teacher = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            teacher = session.get(Teacher.class, teacherId);
            if (teacher != null) {
                Hibernate.initialize(teacher.getTeacherDetails()); // Eagerly load the associated TeacherDetails
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }

        return teacher;
    }

}
