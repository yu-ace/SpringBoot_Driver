package com.web.webdrivercar.dao;

import com.web.webdrivercar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class UserDao {

    @Autowired
    ConnectionPool connectionPool;

    public void register(String name,String password){
        try {
            String str = "insert into user (name,password) values ('%s','%s');";
            String sqlStr = String.format(str,name,password);
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.execute();
            connectionPool.returnConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUser(String name){
        try {
            String str = "select * from user where name = '%s';";
            String sqlStr = String.format(str,name);
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                return null;
            }else{
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String password = resultSet.getString("password");
                User user = new User();
                user.setId(id);
                user.setName(name1);
                user.setPassword(password);
                connectionPool.returnConnection(connection);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
