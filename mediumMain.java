package com.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        // Create a new student
        Student student1 = new Student("John Doe", 22);
        studentDAO.createStudent(student1);
        System.out.println("Created Student: " + student1);

        // Read student by ID
        Student retrievedStudent = studentDAO.getStudent(student1.getId());
        System.out.println("Retrieved Student: " + retrievedStudent);

        // Update student
        retrievedStudent.setAge(23);
        studentDAO.updateStudent(retrievedStudent);
        System.out.println("Updated Student: " + retrievedStudent);

        // Delete student
        studentDAO.deleteStudent(retrievedStudent.getId());
        System.out.println("Deleted Student with ID: " + retrievedStudent.getId());

        // Get all students
        List<Student> students = studentDAO.getAllStudents();
        System.out.println("All Students: " + students);
    }
}
