package com.web.webdrivercar.service.impl;

import com.web.webdrivercar.dao.StudentDao;
import com.web.webdrivercar.model.Student;
import com.web.webdrivercar.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public void newStudent(String name) {
        studentDao.newStudent(name);
    }

    @Override
    public void addGrade(int id, String n, int grade) {
        studentDao.addGrade(id, n, grade);
    }

    @Override
    public List<Student> studentList() {
        return studentDao.getStudentList();
    }
}
