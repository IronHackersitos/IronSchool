package org.example;

import java.util.List;

public class School {

    private String name;
    private List<Course> courses;
    private List<Teacher> teachers;
    private List<Student> students;

    public School(String name, List<Course> courses, List<Teacher> teachers, List<Student> students) {
        setName(name);
        setCourseList(courses);
        setTeacherList(teachers);
        setStudentList(students);
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseList(List<Course> courses) {
        this.courses = courses;
    }

    public void setTeacherList(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setStudentList(List<Student> students) {
        this.students = students;
    }

    //Getters

    public String getName() {
        return name;
    }

    public List<Course> getCourseList() {
        return courses;
    }

    public List<Teacher> getTeacherList() {
        return teachers;
    }

    public List<Student> getStudentList() {
        return students;
    }

    public void enroll(String studentId, String courseId) {
        Student student;
        Course course;
        //tenemos que ir a lo largo de la lista de estudiantes de la escuela para encontrar el estudiante y una vez encontrado hacemos lo mismo para buscar el curso dentro de la lista de cursos
        for (Student s : students) {
            System.out.println("he entrado en el for para buscar al estudiante");
            System.out.println(s.getStudentId());
            System.out.println(studentId);
            if (s.getStudentId().equals(studentId)) {
                System.out.println("he encontrado al estudiante y es");
                student = s;
                System.out.println(student);
                for (Course c : courses) {
                    System.out.println("he entrado en el for para buscar el curso");
                   System.out.println(c);
                    if (c.getCourseId().equals(courseId)) {
                        System.out.println("he encontrado un course y es est");
                        course = c;
                        System.out.println(c);
                        course.getStudentList().add(student);
                        System.out.println("he añadido un estudiante a la lista de estudiantes del curso");
                        System.out.println(course.getStudentList());
                        course.setMoneyEarned(course.getMoneyEarned() + course.getPrice());
                        System.out.println("This is the list of students enrolled in that course so far:");
                        System.out.println(course.getStudentList().toString());
                    } 
                    else System.err.println("There's no course with that id!!");
                }
            } 
            else {
                System.err.println("There's no student with that id!!");

            }
        }

    }

    public void assign(String teacherId, String courseId) {
        Teacher teacher;
        Course course;
        for (Teacher t : teachers) {
            //System.out.println(teachers);
            //System.out.println(t);
            if (t.getTeacherId().equals(teacherId)) {
                teacher = t;
                for (Course c : courses) {
                    if (c.getCourseId().equals(courseId)) {
                        course = c;
                        course.setTeacher(teacher);
                        System.out.println(course.getTeacher().getName() + " has been added to this course: " + course.getName());
                    } else System.err.println("There's no course with that name!!");
                }
            } else System.err.println("There's no teacher with that name!!");
        }
    }

    public List<Course> showCourses() {
        return courses;
    }

    public Course lookUpCourse(String courseId) {
        for (Course c : courses) {
            if (c.getCourseId().equals(courseId))
                return c;
        }
        return null;
    }

    public List<Student> showStudents() {
        return students;
    }

    public Student lookUpStudent(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId))
                return s;
        }
        return null;
    }

    public List<Teacher> showTeachers() {
        return teachers;
    }

    public Teacher lookUpTeacher(String teacherId) {
        for (Teacher t : teachers) {
            if (t.getTeacherId().equals(teacherId))
                return t;
        }
        return null;
    }

    public double showProfit() {
        double courseProfit = 0;
        double total = 0;
        for (Course c : courses) {
            if(c.getTeacher() != null && c.getStudentList().isEmpty() == false){
            courseProfit = c.getMoneyEarned() - c.getTeacher().getSalary();
            total += courseProfit;
            }
            /*else System.out.println("You need to set students and teachers to the course to find the profit");*/
        }
        return total;
        //System.out.println(total + "euro");
    }

    //EXTRAS
    public List<Student> showStudents(String courseId) {
        for (Course c : courses) {
            if (c.getCourseId().equals(courseId)) {
                return c.getStudentList();
            } //else System.err.println("There's no course with that id!!");
        }
        return null;
    }

    public double showMoneyEarned() {
        double total = 0;
        for (Course c : courses) {
            total += c.getMoneyEarned();
        }
        //System.out.println(total + "euro");
        return total;
    }

    public double showMoneySpent() {
        double total = 0;
        for (Course c : courses) {
            total += c.getTeacher().getSalary();
        }
        //System.out.println(total + "euro");
        return total;
    }
    
}
