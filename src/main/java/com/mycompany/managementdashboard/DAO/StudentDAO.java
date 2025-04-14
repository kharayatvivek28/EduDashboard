package com.mycompany.managementdashboard.DAO;

import com.mycompany.managementdashboard.HibernateUtil.HibernateUtil;
import com.mycompany.managementdashboard.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {

    // Save a new student
    public void saveStudent(Student student) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession(); // open session
            tx = session.beginTransaction();

            System.out.println("Saving Student: " + student.getFname() + " " + student.getLname());
            session.save(student);  // Save student to the database
            tx.commit();  // Commit the transaction

            System.out.println("Student saved successfully with ID: " + student.getStudentId());
        } catch (Exception e) {
            if (tx != null) {
                try {
                    tx.rollback(); // rollback only if active
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("Error saving student: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close(); // always close the session!
            }
        }
    }


    // Update existing student
    public void updateStudent(Student student) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(student);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // Delete student by ID
    public void deleteStudent(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // Get student by ID
    public static Student getStudentById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Student.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get student by username and password
    public Student getStudentByUsernameAndPassword(String username, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Student WHERE username = :username AND password = :password", Student.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get all students
    public static List<Student> getAllStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Student getStudentWithDetailsById(int id) {
        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Fetch student and eagerly fetch details
            student = session.createQuery(
                            "FROM Student s LEFT JOIN FETCH s.studentDetails WHERE s.studentId = :id", Student.class)
                    .setParameter("id", id)
                    .uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return student;
    }

}
