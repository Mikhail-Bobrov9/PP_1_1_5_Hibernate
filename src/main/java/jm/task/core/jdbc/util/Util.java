package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    // реализуйте настройку соеденения с БД
    private static final  String URL = "jdbc:mysql://localhost:3306/kata114?useSSL=false&serverTimezone=UTC";
    private static final  String USERNAME = "root1";
    private static final  String PASSWORD = "root";

    public static Connection getConnection()  {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection OK");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }
}

