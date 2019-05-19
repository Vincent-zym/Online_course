package com.demo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.demo.Utils.JdbcUtils;//连接数据库
import com.demo.bean.Student;//实体类

public class StudentDao {
	public Student login(Integer stu_id, String stu_pwd) {  //登录
		Student u = null;
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
		String sql = "select * from student where stu_id=? and stu_pwd=?;";
		pstmt = (PreparedStatement) connection.prepareStatement(sql);
		// 这里的意思将用户名和密码填到SQL语句的问号处
		pstmt.setInt(1, stu_id);//设置预处理语句参数;1代表第一个参数
		pstmt.setString(2, stu_pwd);
		resultSet = pstmt.executeQuery();// 得到数据库的查询结果
		// 判断结果集是否有效
		if(resultSet.next()) {
			u = new Student();
			u.setId(resultSet.getInt("id"));
			u.setStu_id(resultSet.getInt("stu_id"));
			u.setStu_pwd(resultSet.getString("stu_pwd"));
			u.setStu_name(resultSet.getString("stu_name"));
			u.setStu_sex(resultSet.getString("stu_sex"));
			u.setStu_grade(resultSet.getString("stu_grade"));
			u.setStu_tel(resultSet.getString("stu_tel"));
			u.setStu_major(resultSet.getString("stu_major"));
			u.setStu_place(resultSet.getString("stu_place"));
			u.setStu_nation(resultSet.getString("stu_nation"));
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
	return u;
	}
	
	//添加 注册
	public void addStudent(Student student) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = JdbcUtils.getConnection();
			String sql = "insert into student(stu_id,stu_name,stu_pwd,stu_tel)values(?,?,?,?);";
			pstmt = (PreparedStatement) connection.prepareStatement(sql);
			pstmt.setInt(1, student.getStu_id());
			pstmt.setString(2, student.getStu_name());
			pstmt.setString(3, student.getStu_pwd());
			pstmt.setString(4, student.getStu_tel());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//查询所有学生信息
	public List<Student> selectStudent(){
		List<Student> studentList = new ArrayList<>();
		Connection conn = JdbcUtils.getConnection();//连接数据库
		String sql = "select * from student;";
		
		try {
			/*
			PreparedStatement是用来执行SQL查询语句的API之一，Java提供了 Statement、PreparedStatement和
			CallableStatement三种方式来执行查询语句，其中 Statement 用于通用查询
			PreparedStatement 用于执行参数化查询，而 CallableStatement则是用于存储过程。
			*/
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery(); //ResultSet类是一种数据库查询结果存储类;
			while(rst.next()) {
				Student student = new Student();
				student.setId(rst.getInt("id"));
				student.setStu_id(rst.getInt("stu_id"));
				student.setStu_name(rst.getString("stu_name"));
				student.setStu_pwd(rst.getString("stu_pwd"));
				student.setStu_sex(rst.getString("stu_sex"));
				student.setStu_grade(rst.getString("stu_grade"));
				student.setStu_tel(rst.getString("stu_tel"));
				student.setStu_major(rst.getString("stu_major"));
				student.setStu_place(rst.getString("stu_place"));
				student.setStu_nation(rst.getString("stu_nation"));
				studentList.add(student);
			}
			rst.close();//关闭结果集，减少资源使用，关闭顺序和创建相反
			pst.close();//关闭API
		}catch(SQLException e) {
			e.printStackTrace();//查询可能出现空指针异常，打印异常
		}
		return studentList;
	}
	
	//删除一条学生信息	
	public void deleteCourse(int id) {
			Connection conn = JdbcUtils.getConnection();
			String sql = "delete from student where id=?;";
			
			try {
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, id);
				pst.executeUpdate();
				pst.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}	
		
	
	//更新学生信息
	public void updateStudent(Student student) {
		Connection conn = JdbcUtils.getConnection();
		String sql = "update student set stu_name=?,stu_pwd=?,stu_sex=?,stu_grade=?,stu_tel=?,stu_major=?,stu_place=?,stu_nation=? where stu_id=?;";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, student.getStu_name());
			pst.setString(2, student.getStu_pwd());
			pst.setString(3, student.getStu_sex());
			pst.setString(4, student.getStu_grade());
			pst.setString(5, student.getStu_tel());
			pst.setString(6, student.getStu_major());
			pst.setString(7, student.getStu_place());
			pst.setString(8, student.getStu_nation());
			pst.setInt(9, student.getStu_id());
			
			pst.executeUpdate();
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//根据学号查询一条记录
	public Student getStudentById(int stu_id) {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from student where stu_id="+stu_id;
		Student student = new Student();
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				student.setId(rst.getInt("id"));
				student.setStu_id(rst.getInt("stu_id"));
				student.setStu_name(rst.getString("stu_name"));
				student.setStu_pwd(rst.getString("stu_pwd"));
				student.setStu_sex(rst.getString("stu_sex"));
				student.setStu_grade(rst.getString("stu_grade"));
				student.setStu_tel(rst.getString("stu_tel"));
				student.setStu_major(rst.getString("stu_major"));
				student.setStu_place(rst.getString("stu_place"));
				student.setStu_nation(rst.getString("stu_nation"));
			}
			rst.close();
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	
}