package com.web.webdrivercar.service;

import com.web.webdrivercar.model.Student;

import java.util.List;

public interface IStudentService {
    void newStudent(String name);
    void addGrade(int id,int n,int grade);
    List<Student> studentList();
}
