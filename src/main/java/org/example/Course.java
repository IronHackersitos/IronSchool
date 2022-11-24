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
        //Generating random
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        this.courseId = new String(array, Charset.forName("UTF-8"));
        setName(name);
        setPrice(price);
        setMoneyEarned(moneyEarned);
        setTeacher(teacher);
        this.studentList = new ArrayList<>();
    }

    public Course(String name, double price) {
        //Generating random
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        this.courseId = new String(array, Charset.forName("UTF-8"));
        setName(name);
        setPrice(price);
        setMoneyEarned(0);
        this.studentList = new ArrayList<>();
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
                "moneyEarned: " + moneyEarned +'\n' +
                "teacher: " + teacher + '\n' +
                "studentList: " + studentList + '\n' + "------------------\n";
    }
    
}
