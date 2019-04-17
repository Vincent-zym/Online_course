package com.demo.dao;

import java.sql.*;

import com.demo.Utils.JdbcUtils;
import com.demo.bean.User;

public class UserDao {
	public User login(Integer stu_id, String stu_pwd) {
		User u = null;
		//String SQL = "select * from user where stu_id=? and stu_pwd =? ";
		Connection connection = null;
		PreparedStatement pstmt = null;//带参查询语句
		ResultSet resultSet=null;
		
		//赋值
		try {
		connection = JdbcUtils.getConnection();
		String sql = "select * from student where stu_id=? and stu_pwd=?;";
		pstmt = (PreparedStatement) connection.prepareStatement(sql);
		// 这里的意思将用户名和密码填到SQL语句的问号处
		pstmt.setInt(1, stu_id);//设置预处理语句参数;1代表第一个参数
		pstmt.setString(2, stu_pwd);
		resultSet = pstmt.executeQuery();// 得到数据库的查询结果
		// 判断结果集是否有效
		if(resultSet.next()) {
			u = new User();
			u.setStu_id(resultSet.getInt("stu_id"));
			u.setStu_pwd(resultSet.getString("stu_pwd"));
			System.out.println("登录成功！");
		}else {
			System.out.println("用户名或密码错误！");
		}
		resultSet.close();
		pstmt.close();
		connection.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	return u;
	}
	
	//添加 注册
	public void addUser(User user) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = JdbcUtils.getConnection();
			String sql = "insert into student(stu_id,stu_pwd,stu_tel)values(?,?,?);";
			pstmt = (PreparedStatement) connection.prepareStatement(sql);
			pstmt.setInt(1, user.getStu_id());
			pstmt.setString(2, user.getStu_pwd());
			pstmt.setString(3, user.getStu_tel());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}