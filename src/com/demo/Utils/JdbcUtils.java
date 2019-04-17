package com.demo.Utils;

import java.sql.*;

public class JdbcUtils {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/course_selection?useSSL=false&serverTimezone=UTC";
	private static String USER = "root";
	private static String PASSWORD = "yc19970823";
	private static Connection connection = null;
	
	public static Connection getConnection(){

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("数据库连接异常");
            e.printStackTrace();
        }
        return connection;
    }
}
