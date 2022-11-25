package org.example;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Course {
    private final String courseId;
    private String name;
    private double price;
    private double moneyEarned;
    private Teacher teacher;

    private List<Student> studentList;

    public Course(String name, double price, double moneyEarned, Teacher teacher) {
        this.courseId = setRandomId();
        setName(name);
        setPrice(price);
        setMoneyEarned(moneyEarned);
        setTeacher(teacher);
        this.studentList = new ArrayList<>();
    }

    
    public Course(String name, double price) {
        this.courseId = setRandomId();
        setName(name);
        setPrice(price);
        setMoneyEarned(0);
        this.studentList = new ArrayList<>();
    }
    public String setRandomId(){
        //Generating random

        int n = 5;

        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        String randomString = new String(array, Charset.forName("UTF-8"));

        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer();

        // Append first 20 alphanumeric characters
        // from the generated random String into the result
        for (int k = 0; k < randomString.length(); k++) {
            char ch = randomString.charAt(k);
            if (((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) && (n > 0)) {
                r.append(ch);
                n--;
            }
        }
        return r.toString();
    }
    
    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMoneyEarned(double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    //Getters

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getMoneyEarned() {
        return moneyEarned;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    //TO STRING

    @Override
    public String toString() {
        return "COURSE:\n" +
                "courseId: " + courseId + '\n' +
                "name: " + name + '\n' +
                "price: " + price + '\n' +
                "moneyEarned: " + moneyEarned + '\n' +
                "teacher: " + teacher + '\n' +
                "studentList: " + studentList + '\n' + "------------------\n";
    }
    
    public void studentListToString(){
        for(Student s : studentList){
            System.out.println(s.getName());
        }
    }
}
