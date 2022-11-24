package org.example;

import java.nio.charset.Charset;
import java.util.Random;

public class Student {
    private final String studentId;
    private String name;
    private String address;
    private String email;
    private Course course;

    public Student(String name, String address, String email) {
        //Generating random
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        this.studentId = new String(array, Charset.forName("UTF-8"));
        setName(name);
        setAddress(address);
        setEmail(email);
    }
    
    //Setters
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    //Getters

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "STUDENT:\n" +
                "studentId: " + studentId + '\n' +
                "name: " + name + '\n' +
                "address: " + address + '\n' +
                "email: " + email + '\n' +
                "course: " + course + '\n' + "------------------\n";
    }
}
