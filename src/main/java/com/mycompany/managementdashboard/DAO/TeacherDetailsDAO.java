package com.mycompany.managementdashboard.DAO;

import com.mycompany.managementdashboard.model.TeacherDetails;
import com.mycompany.managementdashboard.HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TeacherDetailsDAO {

    public void saveTeacherDetails(TeacherDetails details) {
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

    public void updateTeacherDetails(TeacherDetails details) {
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

    public TeacherDetails getTeacherDetailsById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(TeacherDetails.class, id);
        }
    }

    public void deleteTeacherDetails(TeacherDetails details) {
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
