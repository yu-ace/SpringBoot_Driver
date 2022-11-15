package com.web.webdrivercar.controller;

import com.web.webdrivercar.model.Student;
import com.web.webdrivercar.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    IStudentService studentService;

    @RequestMapping(path="/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(path="/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(path="/newStudent",method = RequestMethod.GET)
    public String newStudent(){
        return "newStudent";
    }


    @RequestMapping(path="/studentList",method = RequestMethod.GET)
    public String studentList(Model model){
        List<Student> student = studentService.studentList();
        model.addAttribute("student",student);
        return "studentList";
    }

    @RequestMapping(path="/addGrade",method = RequestMethod.GET)
    public String addGrade(){
        return "addGrade";
    }
}
