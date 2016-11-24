package com.bruce.http_learning.httpclient_demo;

/**
 * Created by wuteng1 on 2016/9/27.
 */
public class Student {
    private String studentName;
    private String sex;

    public Student() {
    }

    public Student(String studentName, String sex) {

        this.studentName = studentName;
        this.sex = sex;
    }

    public String getStudentName() {

        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
