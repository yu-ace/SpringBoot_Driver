package com.web.webdrivercar.controller;

import com.web.webdrivercar.model.Student;
import com.web.webdrivercar.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    IStudentService studentService;

    @RequestMapping(path="/newStudent",method = RequestMethod.POST)
    public String newStudent(
            @RequestParam(name="name")
            String name){
        studentService.newStudent(name);
        return "newStudent";
    }

    @RequestMapping(path="/addGrade",method = RequestMethod.POST)
    public String addGrade(
            @RequestParam(name="id")
            int id,
            @RequestParam(name="n")
            String n,
            @RequestParam(name="grade")
            int grade){
        studentService.addGrade(id,n,grade);
        return "addGrade";
    }



}
