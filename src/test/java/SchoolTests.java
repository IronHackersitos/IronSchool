import org.example.*;
import org.junit.jupiter.api.AfterEach;
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
    
    @AfterEach
    void tearDown(){
        school = null;
    }

    @Test
    void shouldCreateSchoolWithLists_OK() {
        
        assertEquals(3, school.getStudentList().size());
        assertEquals(3, school.getCourseList().size());
        assertEquals(3, school.getTeacherList().size());
    }
    @Test
    void shouldEnrollStudentToCourse_OK() {
        school.enroll(student1.getStudentId(), school.getCourseList().get(0).getCourseId());
        assertEquals(1, school.getCourseList().get(0).getStudentList().size());
    }
    @Test
    void shouldAssignTeacherToCourse_OK() {
        school.assign(teacher1.getTeacherId(), school.getCourseList().get(0).getCourseId());
        assertEquals("Paco", school.getCourseList().get(0).getTeacher().getName());
    }
    @Test
    void shouldShowCourses_OK() {
        school.showCourses();
        assertEquals(courses, school.getCourseList());
    }

    @Test
    void shouldLookUpCourse_OK() {
        school.lookUpCourse(course1.getCourseId());
        assertEquals(course1, school.lookUpCourse(course1.getCourseId()));
    }

    @Test
    void shouldShowStudents_OK() {
        school.showStudents();
        assertEquals(students, school.getStudentList());
    }

    @Test
    void shouldLookUpStudent_OK() {
        school.lookUpStudent(student1.getStudentId());
        assertEquals(student1, school.lookUpStudent(student1.getStudentId()));
    }

    @Test
    void shouldShowTeachers_OK() {
        school.showTeachers();
        assertEquals(teachers, school.getTeacherList());
    }

    @Test
    void shouldLookUpTeacher_OK() {
        school.lookUpTeacher(teacher1.getTeacherId());
        assertEquals(teacher1, school.lookUpTeacher(teacher1.getTeacherId()));
    }

    @Test
    void shouldShowStudentsFromCourseId_OK() {
        school.enroll(student1.getStudentId(), school.getCourseList().get(0).getCourseId());
        school.enroll(student2.getStudentId(), school.getCourseList().get(0).getCourseId());
        school.enroll(student2.getStudentId(), school.getCourseList().get(0).getCourseId());
        assertEquals(course1.getStudentList(), school.showStudents(course1.getCourseId()));
    }

    @Test
    void shouldShowProfit_OK(){
        //money earned 300
        school.enroll(student1.getStudentId(), school.getCourseList().get(0).getCourseId());
        school.enroll(student2.getStudentId(), school.getCourseList().get(0).getCourseId());
        school.enroll(student2.getStudentId(), school.getCourseList().get(0).getCourseId());
        //moneyearned 600
        school.enroll(student1.getStudentId(), school.getCourseList().get(1).getCourseId());
        school.enroll(student2.getStudentId(), school.getCourseList().get(1).getCourseId());
        school.enroll(student2.getStudentId(), school.getCourseList().get(1).getCourseId());
        //moneyearned 900
        school.enroll(student1.getStudentId(), school.getCourseList().get(2).getCourseId());
        school.enroll(student2.getStudentId(), school.getCourseList().get(2).getCourseId());
        school.enroll(student2.getStudentId(), school.getCourseList().get(2).getCourseId());
        //expenses total 150
        school.assign(teacher1.getTeacherId(), school.getCourseList().get(0).getCourseId());
        school.assign(teacher2.getTeacherId(), school.getCourseList().get(1).getCourseId());
        school.assign(teacher3.getTeacherId(), school.getCourseList().get(2).getCourseId());
        
        school.showProfit();
        assertEquals(1650, school.showProfit());
    }

    @Test
    void shouldShowMoneyEarned_OK(){
        //money earned 300
        school.enroll(student1.getStudentId(), school.getCourseList().get(0).getCourseId());
        school.enroll(student2.getStudentId(), school.getCourseList().get(0).getCourseId());
        school.enroll(student2.getStudentId(), school.getCourseList().get(0).getCourseId());
        //moneyearned 600
        school.enroll(student1.getStudentId(), school.getCourseList().get(1).getCourseId());
        school.enroll(student2.getStudentId(), school.getCourseList().get(1).getCourseId());
        school.enroll(student2.getStudentId(), school.getCourseList().get(1).getCourseId());
        //moneyearned 900
        school.enroll(student1.getStudentId(), school.getCourseList().get(2).getCourseId());
        school.enroll(student2.getStudentId(), school.getCourseList().get(2).getCourseId());
        school.enroll(student2.getStudentId(), school.getCourseList().get(2).getCourseId());
        
        school.showMoneyEarned();
        assertEquals(1800, school.showMoneyEarned());
    }

    @Test
    void shouldShowMoneySpent_OK(){
        //expenses total 150
        school.assign(teacher1.getTeacherId(), school.getCourseList().get(0).getCourseId());
        school.assign(teacher2.getTeacherId(), school.getCourseList().get(1).getCourseId());
        school.assign(teacher3.getTeacherId(), school.getCourseList().get(2).getCourseId());

        school.showMoneySpent();
        assertEquals(150, school.showMoneySpent());
    }


}
