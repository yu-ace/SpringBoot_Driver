package com.web.webdrivercar.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Deque;
import java.util.LinkedList;

@Component
public class ConnectionPool {
    @Value("${connection.url}")
    String url = "";
    @Value("${connection.user}")
    String user = "root";
    @Value("${connection.password}")
    String password = "123456";
    @Value("${connection.className}")
    String className = "";
    int minNumber = 3;
    int createNumber = 5;
    int maxFreeNumber = 8;
    int maxConnectionNumber = 60;

    private Deque<Connection> freeConnectionList = new LinkedList<>();

    int size = 0;


    public Connection open() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        freeConnectionList.add(connection);
        size++;
        return connection;
    }

    public Connection getConnection() throws Exception {
        if(freeConnectionList == null && size == maxConnectionNumber){
            throw new Exception("连接池无空余连接");
        }
        if(freeConnectionList.size() < minNumber){
            open();
        }else{
            removeFreeConnection();
        }
        Connection connection = freeConnectionList.removeFirst();
        return connection;
    }

    public void returnConnection(Connection connection) {
        freeConnectionList.add(connection);
    }

    public void removeFreeConnection(){
        if(freeConnectionList.size() > maxFreeNumber){
            for(int i = 0;i < createNumber;i++){
                Connection connection = freeConnectionList.removeFirst();
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
