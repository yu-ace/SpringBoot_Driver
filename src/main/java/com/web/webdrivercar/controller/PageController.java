package com.web.webdrivercar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {


    @RequestMapping(path="/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(path="register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(path="newStudent",method = RequestMethod.GET)
    public String newStudent(){
        return "newStudent";
    }

    @RequestMapping(path="studentList",method = RequestMethod.GET)
    public String studentList(){
        return "studentList";
    }

    @RequestMapping(path="addGrade",method = RequestMethod.GET)
    public String addGrade(){
        return "addGrade";
    }
}
