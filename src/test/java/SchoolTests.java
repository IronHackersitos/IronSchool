import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchoolTests {
        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Teacher>  teachers = new ArrayList<>();
        
        School school;
        Student student1;
        Student student2;
        Student student3;
        Course course1;
        Course course2;
        Course course3;
        Teacher teacher1;
        Teacher teacher2;
        Teacher teacher3;
    
    @BeforeEach
    void setUp() {
        student1 = new Student("julia", "tralari", "aksashd@sakdhf");
        student2 = new Student("julia2", "tralareswfai", "sakshd@sakdhf");
        student3 = new Student("julia3", "treawfalari", "akssssshd@sakdhf");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        
        course1 = new Course("Tema1", 100);
        course2 = new Course("Tema2", 200);
        course3 = new Course("Tema3", 300);
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        
        teacher1 = new Teacher("Paco", 50);
        teacher2 = new Teacher("Paco2", 50);
        teacher3 = new Teacher("Paco3", 50);
        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);
        
        school = new School("escuelita", courses, teachers, students);
    }

    @Test
    void shouldCreateSchoolWithLists() {
        
        assertEquals(3, school.getStudentList().size());
        assertEquals(3, school.getCourseList().size());
        assertEquals(3, school.getTeacherList().size());
    }
    @Test
    void shouldEnrollStudentToCourse() {
        school.enroll(student1.getStudentId(), school.getCourseList().get(0).getCourseId());
        assertEquals(1, school.getCourseList().get(0).getStudentList().size());
    }
    @Test
    void shouldAssignTeacherToCourse() {
        school.assign(teacher1.getTeacherId(), school.getCourseList().get(0).getCourseId());
        assertEquals("Paco", school.getCourseList().get(0).getTeacher().getName());
    }
    @Test
    void shouldShowCourses() {
        school.showCourses();
        assertEquals(courses, school.getCourseList());
    }

    @Test
    void shouldShowCourses() {
        school.showCourses();
        assertEquals(courses, school.getCourseList());
    }
    
}
