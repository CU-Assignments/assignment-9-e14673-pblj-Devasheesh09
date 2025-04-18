import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        // Load the Spring context using Java configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the Student bean from the context
        Student student = context.getBean(Student.class);

        // Print the details of the student
        System.out.println(student);
    }
}
