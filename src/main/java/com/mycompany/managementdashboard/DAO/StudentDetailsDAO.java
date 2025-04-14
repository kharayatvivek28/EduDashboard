package com.mycompany.managementdashboard.DAO;

import com.mycompany.managementdashboard.model.Student;
import com.mycompany.managementdashboard.model.StudentDetails;
import com.mycompany.managementdashboard.HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDetailsDAO {

    public void saveStudentDetails(StudentDetails details) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(details);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void updateStudentDetails(StudentDetails details) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(details);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public StudentDetails getStudentDetailsById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(StudentDetails.class, id);
        }
    }
    public static List<Student> getAllStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        }
    }

    public void deleteStudentDetails(StudentDetails details) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(details);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
