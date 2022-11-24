package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("WELCOME TO IRONSCHOOL BY IRONHACKERSITOS");
        
        //SCHOOL NAME
        Scanner input = new Scanner(System.in);
        System.out.println("What is the name of your school?");
        String name = saveString(input);

        //TEACHERS
        System.out.println("How many teachers do you want?");
        int teacherNum = saveInt(input);
        List<Teacher> teachers = new ArrayList<>();

        System.out.println("Entering teacher details:");
        while (teacherNum > 0) {
            System.out.println("What is his/her name?");
            String teacherName = saveString(input);
            System.out.println("What is his/her salary?");
            int teacherSalary = saveInt(input);
            Teacher teacher = new Teacher(teacherName, teacherSalary);
            teachers.add(teacher);
            teacherNum--;
        }

        //COURSES
        System.out.println("How many courses will you want?");
        int coursesNum = saveInt(input);
        List<Course> courses = new ArrayList<>();

        System.out.println("Entering courses details:");
        while (coursesNum > 0) {
            System.out.println("What is the course name?");
            String courseName = saveString(input);
            System.out.println("What is the course price?");
            Double price = saveDouble(input);
            System.out.println("What is the money earned with this course?");
            Double moneyEarned = saveDouble(input);
            Course course = new Course( courseName, price, moneyEarned);
            courses.add(course);
            coursesNum--;
        }
        
        //STUDENTS
        System.out.println("How many students will you have?");
        int studentNum = saveInt(input);
        List<Student> students = new ArrayList<>();

        System.out.println("Entering students details");
        while(studentNum > 0){
            System.out.println("What is his/her name?");
            String studentName = saveString(input);
            System.out.println("What is his/her address?");
            String studentAddress = saveString(input);
            System.out.println("What is his/her email?");
            String studentEmail = saveString(input);
            Student student = new Student(studentName, studentAddress, studentEmail);
            students.add(student);
            studentNum--;
        }

        System.out.println("Creating your school ...");
        School school = new School(name, teacherNum, coursesNum, studentNum);
        school.setStudentList(students);
        school.setTeacherList(teachers);
        school.setCourseList(courses);
        
        System.out.println("What do you want to do now?");
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            int selection = 0;

            try {
                selection = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Enter only integer values");
                input.nextLine();
            }

            switch (selection) {
                case 1:
                    System.out.println("Which student do you want to enroll?");
                    String studentId = saveString(input);
                    System.out.println("To which course do you want to assign him/her?");
                    String courseId = saveString(input);
                    //enroll(studentId, courseId, students, courses);
                    school.enroll(studentId, courseId);
                    
                    break;
                case 2:
                    System.out.println("Which teacher do you want to assign?");
                    String teacherId = saveString(input);
                    System.out.println("To which course do you want to assign him/her?");
                    String courseId = saveString(input);
                    //assign(teacherId, courseId, teachers, courses);
                    school.assign(teacherId, courseId);
                    break;
                case 3:
                    System.out.println("Here's a list with all the school's available courses");
                    //showCourses(courses);
                    school.showCourses();
                    break;
                case 4:
                    System.out.println("Enter id of course you want to look up:");
                    String courseId = saveString(input);
                    System.out.println("Showing course details:");
                    //lookUpCourse(courseId);
                    school.lookUpCourse(courseId);
                    break;
                case 5:
                    System.out.println("Here's a list with all the school's students");
                    //showStudents(students);
                    school.showStudents();
                    break;
                case 6:
                    System.out.println("Enter id of student you want to look up:");
                    String studentId = saveString(input);
                    System.out.println("Showing student details:");
                    //lookUpStudent(studentId);
                    school.lookUpStudent(studentId);
                    break;
                case 7:
                    System.out.println("Here's a list with all the school's teachers");
                    //showTeachers(teachers);
                    school.showTeachers();
                    break;
                case 8:
                    System.out.println("Enter id of teacher you want to look up:");
                    String teacherId = saveString(input);
                    System.out.println("Showing teacher details");
                    //lookUpTeacher(teacherId);
                    school.lookUpTeacher(teacherId);
                    break;
                case 9:
                    System.out.println("Here's the amount of school's profits:");
                    //showProfit(school);
                    school.showProfit();
                    break;
                case 10:
                    System.out.println("Enter id of course whose students you want to see:");
                    String courseId = saveString(input);
                    System.out.println("Showing course students:");
                    school.showStudents(courseId);
                    break;
                case 11:
                    System.out.println("Here's the amount of school's money earned:");
                    school.showMoneyEarned();
                    break;
                case 12:
                    System.out.println("Here's the amount of school's money earned:");
                    school.showMoneySpent();
                    break;
                case 13:
                    System.out.println("C ya!!!");
                    isRunning = false;
                    break;
                default:
                    System.err.println("Enter only integer values");
                    
            }
        }
        


    }

    //MENU
    private static void showMenu() {
        System.out.println("Select an option:");
        System.out.println("1. Enroll a student to a course");
        System.out.println("2. Assign a teacher to a course");
        System.out.println("3. Show courses");
        System.out.println("4. Show course details");
        System.out.println("5. Show students");
        System.out.println("6. Show student details");
        System.out.println("7. Show teachers");
        System.out.println("8. Show teacher details");
        System.out.println("9. Show profit");
        System.out.println("10. Show course students");
        System.out.println("11. Show money earned");
        System.out.println("12. Show money spent");
        System.out.println("13. Exit");
    }
    
    //INPUT SAVING
    public static String saveString(Scanner input) {
        String name = "";
        while (name == null || name == "") {
            System.out.println("Enter a word/sentence");
            if (input.hasNextLine())
                name = input.nextLine();
        }
        return name;
    }

    public static int saveInt(Scanner input) {
        int num = -1;
        while (num <= 0) {
            System.out.println("Enter a positive number");
            try {
                num = Integer.valueOf(input.nextLine());
            } catch (NumberFormatException e) {
                num = -1;
            }
            if (num <= 0) {
                System.err.println("Enter a positive number");
            }
        }
        return num;
    }

    public static double saveDouble(Scanner input) {
        int num = -1;
        while (num <= 0) {
            System.out.println("Enter a positive number");
            try {
                num = Integer.valueOf(input.nextLine());
            } catch (NumberFormatException e) {
                num = -1;
            }
            if (num <= 0) {
                System.err.println("Enter a positive number");
            }
        }
        return num;
    }
    
    //ENROLL STUDENT
    /*public static void enroll(String studentId, String  courseId, List<Student> students, List<Course> courses){
        Student student;
        Course course;
        for(Student s : students){
            if(s.getStudentId().equals(studentId)){
                student = s;
                for(Course c : courses){
                    if(c.getCourseId().equals(courseId)){
                        course = c;
                        course.getStudentList().add(student);
                        course.setMoneyEarned(course.getMoneyEarned() + course.getPrice());
                        System.out.println("This is the list of students enrolled in that course so far:");
                        System.out.println(course.getStudentList().toString());
                    }
                    else return;
                }
            }
            else return;
        }
   
    }*/
    
    //ASSIGN TEACHER
   /* public static void assign(String teacherId, String  courseId, List<Teacher> teachers, List<Course> courses){

        Teacher teacher;
        Course course;
        for(Teacher t : teachers){
            if(t.getTeacherId().equals(teacherId)){
                teacher = t;
                for(Course c : courses){
                    if(c.getCourseId().equals(courseId)){
                        course = c;
                        course.setTeacher(teacher);
                        System.out.println(course.getTeacher() + " has been added to this course: " + course.getName());
                    }
                    else return;
                }
            }
            else return;
        }
    }*/
    
    //SHOW COURSES
    /*public static void showCourses(List<Course> courses){
        for(Course c : courses){
            System.out.println(c);
        }
    }*/
    
    //LOOK UP COURSE
    /*public static void lookUpCourse(String courseId, List<Course> courses){
        for(Course c : courses){
            if (c.getCourseId().equals(courseId))
                System.out.println(c);
        }
    }*/

    //SHOW STUDENTS
    /*public static void showStudents(List<Student> students){
        for(Student s : students){
            System.out.println(s);
        }
    }*/

    //LOOK UP STUDENT
    /*public static void lookUpStudent(String studentId, List<Student> students){
        for(Student s : students){
            if (s.getStudentId().equals(studentId))
                System.out.println(s);
        }
    }*/
    
    //SHOW TEACHERS
    /*public static void showTeachers(List<Teacher> teachers){
        for(Teacher t : teachers){
            System.out.println(t);
        }
    }*/
    
    //LOOK UP TEACHER
    /*public static void lookUpTeacher(String teacherId, List<Teacher> teachers){
        for(Teacher t : teachers){
            if (t.getTeacherId().equals(teacherId))
                System.out.println(t);
        }
    }*/
    
    //SHOW PROFITS
    /*public static void showProfit(School school){
        List<Course> courses = school.getCourseList();
        double courseProfit = 0;
        double total = 0;
        for(Course c : courses){
            courseProfit = c.getMoneyEarned() - c.getTeacher().getSalary();
            total += courseProfit;
        }
        System.out.println("Total profits of this school  are: " + total);
    }*/
}