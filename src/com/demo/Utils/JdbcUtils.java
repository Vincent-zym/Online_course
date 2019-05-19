package com.demo.Utils;
//导入数据相关的包
import java.sql.*;

public class JdbcUtils {
	private static String driver = "com.mysql.cj.jdbc.Driver"; //数据库驱动，mysql8.0是这样，其他可能不同
	//url，mysql8.0与mysql5.x不同，其他版本请百度
	private static String URL = "jdbc:mysql://localhost:3306/course_selection?useSSL=false&serverTimezone=UTC";
	private static String USER = "root";//数据库用户名
	private static String PASSWORD = "yc19970823";//数据库密码
	private static Connection connection = null;//创建连接
	
	public static Connection getConnection(){
        try {
            Class.forName(driver);//加载驱动
            connection = DriverManager.getConnection(URL, USER, PASSWORD);//连接
        } catch (Exception e) {
            System.out.println("数据库连接异常");
            e.printStackTrace();
        }
        return connection;
    }
}
