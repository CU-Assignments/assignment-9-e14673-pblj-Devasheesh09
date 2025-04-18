public class Student {
    private String name;
    private Course course; // Reference to the Course class

    // Constructor
    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    // toString method to display the student details
    @Override
    public String toString() {
        return "Student [name=" + name + ", course=" + course + "]";
    }
}
