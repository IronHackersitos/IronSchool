package org.example;

import java.util.List;

public class School {

    private String name;
    private int teacherNum;
    private int courseNum;
    private int studentNum;
    private List<Course> courses;
    private List<Teacher> teachers;
    private List<Student> students;

    public School(String name, int teacherNum, int courseNum, int studentNum) {
        setName(name);
        setTeacherNum(teacherNum);
        setCourseNum(courseNum);
        setStudentNum(studentNum);
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacherNum(int teacherNum) {
        this.teacherNum = teacherNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
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

    public int getTeacherNum() {
        return teacherNum;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public int getStudentNum() {
        return studentNum;
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
        for (Student s : students) {
            System.out.println(s);
            if (s.getStudentId().equals(studentId)) {
                //System.out.println("entro aqui");
                student = s;
                //System.out.println(student);
                for (Course c : courses) {
                   // System.out.println(c);
                    if (c.getCourseId().equals(courseId)) {
                        //System.out.println("he encontrado un course");
                        course = c;
                        //System.out.println(c);
                        course.getStudentList().add(student);
                        //System.out.println(course.getStudentList());
                        course.setMoneyEarned(course.getMoneyEarned() + course.getPrice());
                        System.out.println("This is the list of students enrolled in that course so far:");
                        System.out.println(course.getStudentList().toString());
                    } else System.err.println("There's no course with that name!!");
                }
            } else {
                System.err.println("There's no student with that name!!");

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

    public void showCourses() {
        for (Course c : courses) {
            System.out.println(c.toString());
        }
    }

    public void lookUpCourse(String courseId) {
        for (Course c : courses) {
            if (c.getCourseId().equals(courseId))
                System.out.println(c);
        }
    }

    public void showStudents() {
        for (Student s : students) {
            System.out.println(s.toString());
        }
    }

    public void lookUpStudent(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId))
                System.out.println(s);
        }
    }

    public void showTeachers() {
        for (Teacher t : teachers) {
            System.out.println(t);
        }
    }

    public void lookUpTeacher(String teacherId) {
        for (Teacher t : teachers) {
            if (t.getTeacherId().equals(teacherId))
                System.out.println(t);
        }
    }

    public void showProfit() {
        double courseProfit = 0;
        double total = 0;
        for (Course c : courses) {
            if(c.getTeacher() != null && c.getStudentList().isEmpty() == false){
            courseProfit = c.getMoneyEarned() - c.getTeacher().getSalary();
            total += courseProfit;}
            else System.out.println("You need to set students and teachers to the course to find the profit");
        }
        System.out.println(total + "euro");
    }

    //EXTRAS
    public void showStudents(String courseId) {
        for (Course c : courses) {
            if (c.getCourseId().equals(courseId)) {
                System.out.println(c.getStudentList());
            } else System.err.println("There's no course with that id!!");
        }
    }

    public void showMoneyEarned() {
        double total = 0;
        for (Course c : courses) {
            total += c.getMoneyEarned();
        }
        System.out.println(total + "euro");
    }

    public void showMoneySpent() {
        double total = 0;
        for (Course c : courses) {
            total += c.getTeacher().getSalary();
        }
        System.out.println(total + "euro");
    }
}
