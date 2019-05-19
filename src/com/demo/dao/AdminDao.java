package com.demo.dao;

import java.sql.*;

import com.demo.Utils.JdbcUtils;//连接数据库
import com.demo.bean.Admin;//实体类

public class AdminDao {
	public Admin login(Integer adm_id, String adm_pwd) {  //登录
		Admin adm = null;
		Connection connection = null;
		/*
		PreparedStatement是用来执行SQL查询语句的API之一，Java提供了 Statement、PreparedStatement和
		CallableStatement三种方式来执行查询语句，其中 Statement 用于通用查询
		PreparedStatement 用于执行参数化查询，而 CallableStatement则是用于存储过程。
		*/
		PreparedStatement pstmt = null;//带参查询语句
		ResultSet resultSet=null;//ResultSet类是一种数据库查询结果存储类;
		
		try {//赋值，连接数据库可能出现空指向异常，对其进行抛出
		connection = JdbcUtils.getConnection();//调用数据库的连接方法，连接数据库。
		String sql = "select * from manager where adm_id=? and adm_pwd=?;";
		pstmt = (PreparedStatement) connection.prepareStatement(sql);
		// 这里的意思将用户名和密码填到SQL语句的问号处
		pstmt.setInt(1, adm_id);//设置预处理语句参数;1代表第一个参数
		pstmt.setString(2, adm_pwd);
		resultSet = pstmt.executeQuery();// 得到数据库的查询结果
		// 判断结果集是否有效
		if(resultSet.next()) {
			adm = new Admin();
			adm.setAdm_id(resultSet.getInt("adm_id"));
			adm.setAdm_pwd(resultSet.getString("adm_pwd"));
			System.out.println("登录成功！");
		}else {
			System.out.println("用户名或密码错误！");
		}
		resultSet.close();//逻辑处理完关闭其资源库，减少资源负担，其先创建的后关
		pstmt.close();
		connection.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	return adm;
	}
	
	//添加 注册
	public void addAdmin(Admin admin) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = JdbcUtils.getConnection();
			String sql = "insert into manager(adm_id,adm_pwd,adm_tel)values(?,?,?);";
			pstmt = (PreparedStatement) connection.prepareStatement(sql);
			pstmt.setInt(1, admin.getAdm_id());
			pstmt.setString(2, admin.getAdm_pwd());
			pstmt.setString(3, admin.getAdm_tel());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}