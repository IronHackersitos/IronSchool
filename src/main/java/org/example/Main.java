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
            Course course = new Course(courseName, price);
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
        School school = new School(name, courses, teachers, students);
        
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
                    if(school.lookUpStudent(studentId) == null){
                        System.err.println("That student doesn't exist yet");
                        break;}
                    System.out.println("To which course do you want to assign him/her?");
                    String courseId = saveString(input);
                    if(school.lookUpCourse(courseId) == null){
                        System.err.println("That course doesn't exist yet.");
                        break;
                    }
                    school.enroll(studentId, courseId);
                    System.out.println("Here is the list of students enrolled in this course so far:");
                    school.lookUpCourse(courseId).studentListToString();
                    break;
                case 2:
                    System.out.println("Which teacher do you want to assign?");
                    String teacherId = saveString(input);
                    if(school.lookUpTeacher(teacherId) == null){
                        System.err.println("That teacher doesn't exist yet");
                        break;
                    }
                    System.out.println("To which course do you want to assign him/her?");
                    String courseId2 = saveString(input);
                    if(school.lookUpCourse(courseId2) == null){
                        System.err.println("That course doesn't exist yet.");
                        break;
                    }
                    school.assign(teacherId, courseId2);
                    System.out.println("Here is the course with the new teacher assigned:" + school.lookUpCourse(courseId2).toString());
                    break;
                case 3:
                    System.out.println("Here's a list with all the school's available courses");
                    System.out.println(school.showCourses().toString());
                    //school.courseListToString();
                    break;
                case 4:
                    System.out.println("Enter id of course you want to look up:");
                    String courseId3 = saveString(input);
                    if(school.lookUpCourse(courseId3) == null){
                        System.err.println("That course doesn't exist yet.");
                        break;
                    }
                    System.out.println("Showing course details:");
                    System.out.println(school.lookUpCourse(courseId3).toString());
                    break;
                case 5:
                    System.out.println("Here's a list with all the school's students");
                    System.out.println(school.showStudents().toString());
                    break;
                case 6:
                    System.out.println("Enter id of student you want to look up:");
                    String studentId1 = saveString(input);
                    if(school.lookUpStudent(studentId1) == null){
                        System.err.println("That student doesn't exist yet");
                        break;}
                    System.out.println("Showing student details:");
                    System.out.println(school.lookUpStudent(studentId1).toString());
                    break;
                case 7:
                    System.out.println("Here's a list with all the school's teachers");
                    System.out.println(school.showTeachers().toString());
                    break;
                case 8:
                    System.out.println("Enter id of teacher you want to look up:");
                    String teacherId1 = saveString(input);
                    if(school.lookUpTeacher(teacherId1) == null){
                        System.err.println("That teacher doesn't exist yet");
                        break;
                    }
                    System.out.println("Showing teacher details");
                    System.out.println(school.lookUpTeacher(teacherId1).toString());
                    break;
                case 9:
                    System.out.println("Here's the amount of school's profits:");
                    System.out.println(school.showProfit() + " euros");
                    break;
                case 10:
                    System.out.println("Enter id of course whose students you want to see:");
                    String courseId4 = saveString(input);
                    if(school.lookUpCourse(courseId4) == null){
                        System.err.println("That course doesn't exist yet.");
                        break;
                    }
                    System.out.println("Showing course students:");
                    System.out.println(school.showStudents(courseId4).toString());
                    break;
                case 11:
                    System.out.println("Here's the amount of school's money earned:");
                    try{
                        System.out.println(school.showMoneyEarned() + " euros");
                    }catch (NullPointerException e){
                        System.err.println("You must assign students to all courses to see the total money earned");
                    }
                    break;
                case 12:
                    System.out.println("Here's the amount of school's money earned:");
                    try {
                        System.out.println(school.showMoneySpent() + " euros");
                    }catch (NullPointerException e){
                        System.err.println("You must assign teachers to all courses to see the total money spent");
                    }
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
}