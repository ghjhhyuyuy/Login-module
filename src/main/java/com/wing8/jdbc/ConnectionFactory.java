package com.wing8.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
    //准备参数
    private static final String URL = "jdbc:mysql://106.12.30.95:3306/loginwing?useUnicode=true&characterEncoding=utf-8";
    private static final String User = "loginwing";
    private static final String password = "123456";

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,User,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}