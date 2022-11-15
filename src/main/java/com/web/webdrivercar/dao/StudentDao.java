package com.web.webdrivercar.dao;

import com.web.webdrivercar.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDao {

    @Autowired
    ConnectionPool connectionPool;

    public void newStudent(String name){
        try {
            String str = "insert into student(name) values ('%s');";
            String sqlStr = String.format(str,name);
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.execute();
            connectionPool.returnConnection(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addGrade(int id,int n,int grade){
        try {
            String str = "update student set %d = %d where id = %d;";
            String sqlStr = String.format(str,n,grade,id);
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.execute();
            connectionPool.returnConnection(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> studentList(){
        try {
            String str = "select * from student;";
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(str);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> studentList = new ArrayList<>();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int class1 = resultSet.getInt("1");
                int class2 = resultSet.getInt("2");
                int class3 = resultSet.getInt("3");
                int class4 = resultSet.getInt("4");
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setClass1Grade(class1);
                student.setClass2Grade(class2);
                student.setClass3Grade(class3);
                student.setClass4Grade(class4);
                studentList.add(student);
            }
            connectionPool.returnConnection(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return studentList();
    }

}
