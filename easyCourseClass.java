public class Course {
    private String courseName;
    private int duration; // Duration in months

    // Constructor
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Getters
    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }

    // toString method to display the course details
    @Override
    public String toString() {
        return "Course [courseName=" + courseName + ", duration=" + duration + " months]";
    }
}
