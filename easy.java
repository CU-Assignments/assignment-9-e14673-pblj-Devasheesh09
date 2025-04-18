import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Define a bean for Course
    @Bean
    public Course course() {
        return new Course("Java Programming", 6); // Example course with 6 months duration
    }

    // Define a bean for Student and inject Course bean as a dependency
    @Bean
    public Student student() {
        return new Student("John Doe", course()); // Injecting Course bean into Student
    }
}
