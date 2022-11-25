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
            //System.out.println("he entrado en el for para buscar al estudiante");
            //System.out.println(s.getStudentId());
            //System.out.println(studentId);
            if (s.getStudentId().equals(studentId)) {
                //System.out.println("he encontrado al estudiante y es");
                //student = s;
                //System.out.println(student);
                for (Course c : courses) {
                    // System.out.println("he entrado en el for para buscar el curso");
                    //System.out.println(c);
                    if (c.getCourseId().equals(courseId)) {
                        //System.out.println("he encontrado un course y es est");
                        //course = c;
                        //System.out.println(c);
                        c.getStudentList().add(s);
                        //System.out.println("he añadido un estudiante a la lista de estudiantes del curso");
                        //System.out.println(course.getStudentList());
                        c.setMoneyEarned(c.getMoneyEarned() + c.getPrice());
                        //System.out.println("This is the list of students enrolled in that course so far:");
                        //System.out.println(course.getStudentList().toString());
                    }
                }
            }
        }

    }

    public void assign(String teacherId, String courseId) {
        for (Teacher t : teachers) {
            if (t.getTeacherId().equals(teacherId)) {
                for (Course c : courses) {
                    if (c.getCourseId().equals(courseId)) {
                        c.setTeacher(t);
                    }
                }
            }
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
        double schoolProfit = 0;
        double total = 0;
        for (Course c : courses) {
            if (c.getStudentList().isEmpty() == true) {
                System.err.println("You need to set students to all courses");
                return 0;
            } else if (c.getTeacher() == null) {
                System.err.println("You need to set a teacher to all courses");
                return 0;
            } else {
                schoolProfit = c.getMoneyEarned() - c.getTeacher().getSalary();
                total += schoolProfit;
            }
        }
        return total;
    }

    //EXTRAS
    public List<Student> showStudents(String courseId) {
        for (Course c : courses) {
            if (c.getCourseId().equals(courseId)) {
                return c.getStudentList();
            }
        }
        return null;
    }

    public double showMoneyEarned() {
        double total = 0;
        for (Course c : courses) {
            if(c.getMoneyEarned() == 0){
                throw new NullPointerException();
            }
            else total += c.getMoneyEarned();
        }
        return total;
    }

    public double showMoneySpent() {
        double total = 0;
        for (Course c : courses) {
            if(c.getTeacher() == null){
                throw new NullPointerException();
            }
            else total += c.getTeacher().getSalary();
        }
        return total;
    }

    public void studentListToString() {
        for (Student s : students) {
            System.out.println(s.getName());
        }
    }

    public void teacherListToString() {
        for (Teacher t : teachers) {
            System.out.println(t.getName());
        }
    }

    public void courseListToString() {
        for (Course c : courses) {
            System.out.println(c.getName());
        }
    }

}
