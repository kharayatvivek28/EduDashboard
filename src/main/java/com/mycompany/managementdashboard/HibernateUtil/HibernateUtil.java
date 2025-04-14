package com.mycompany.managementdashboard.HibernateUtil;

import com.mycompany.managementdashboard.model.Admin;
import com.mycompany.managementdashboard.model.Teacher;
import com.mycompany.managementdashboard.model.TeacherDetails;
import com.mycompany.managementdashboard.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

            // Register annotated entity classes
            configuration.addAnnotatedClass(Admin.class);
            configuration.addAnnotatedClass(Teacher.class);
            configuration.addAnnotatedClass(TeacherDetails.class);
            configuration.addAnnotatedClass(Student.class);

            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            System.out.println("Hibernate Exception: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession(); // ✅ SAFE
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}
