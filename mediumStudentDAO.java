package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAO {

    // Create student
    public void createStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            // Start a transaction
            session.beginTransaction();
            // Save the student object
            session.save(student);
            // Commit the transaction
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    // Read student by ID
    public Student getStudent(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            // Start a transaction
            session.beginTransaction();
            // Get the student object
            Student student = session.get(Student.class, id);
            // Commit the transaction
            session.getTransaction().commit();
            return student;
        } finally {
            session.close();
        }
    }

    // Update student
    public void updateStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            // Start a transaction
            session.beginTransaction();
            // Update the student object
            session.update(student);
            // Commit the transaction
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    // Delete student
    public void deleteStudent(int studentId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            // Start a transaction
            session.beginTransaction();
            // Get the student object by primary key
            Student student = session.get(Student.class, studentId);
            // Delete the student object
            if (student != null) {
                session.delete(student);
            }
            // Commit the transaction
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    // Get all students
    public List<Student> getAllStudents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            // Start a transaction
            session.beginTransaction();
            // Query all students
            Query<Student> query = session.createQuery("from Student", Student.class);
            List<Student> students = query.getResultList();
            // Commit the transaction
            session.getTransaction().commit();
            return students;
        } finally {
            session.close();
        }
    }
}
