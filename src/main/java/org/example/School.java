package org.example;

import java.util.List;

public class School {
    
    private String name;
    private int teacherNum;
    private int courseNum;
    private int studentNum;
    private List<Course> courseList;

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

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
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
        return courseList;
    }
}
