package org.example;

import java.nio.charset.Charset;
import java.util.Random;

public class Teacher {
    private final String teacherId;
    private String name;
    private double salary;

    public Teacher(String name, double salary) {
        //Generating random
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        this.teacherId = new String(array, Charset.forName("UTF-8"));
        setName(name);
        setSalary(salary);
    }
    
    //Setters
    
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    //Getter
    
    public String getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
