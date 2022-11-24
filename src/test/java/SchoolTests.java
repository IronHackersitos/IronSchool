import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchoolTests {
    @Test
    void shouldEnrollStudentToCourse(){
        Student student = new Student("julia", "tralari", "akshd@sakdhf");
        Course course = new Course("dhf", 54631);
        School school = new School("escuelita", 1, 1, 1);
        school.enroll(student.getStudentId(), course.getCourseId());
        assertEquals(1, course.getStudentList().size());
    }
}
