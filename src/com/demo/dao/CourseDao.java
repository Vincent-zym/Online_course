package com.demo.dao;

//引入包
import java.sql.*;
import java.util.*;

import com.demo.bean.Course;
import com.demo.Utils.JdbcUtils;

public class CourseDao {

	//查询所有课程信息
	public List<Course> selectCourse(){
		List<Course> courseList = new ArrayList<>();
		Connection conn = JdbcUtils.getConnection();//连接数据库
		String sql = "select * from course;";
		
		try {
			/*
			PreparedStatement是用来执行SQL查询语句的API之一，Java提供了 Statement、PreparedStatement和
			CallableStatement三种方式来执行查询语句，其中 Statement 用于通用查询
			PreparedStatement 用于执行参数化查询，而 CallableStatement则是用于存储过程。
			*/
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery(); //ResultSet类是一种数据库查询结果存储类;
			while(rst.next()) {
				Course course = new Course();
				course.setCourse_id(rst.getInt("course_id"));
				course.setCourse_name(rst.getString("course_name"));
				course.setCourse_tea(rst.getString("course_tea"));
				course.setCourse_hour(rst.getInt("course_hour"));
				course.setCourse_mark(rst.getFloat("course_mark"));
				course.setCourse_time(rst.getString("course_time"));
				course.setCourse_place(rst.getString("course_place"));
				courseList.add(course);
			}
			rst.close();//关闭结果集，减少资源使用，关闭顺序和创建相反
			pst.close();//关闭API
		}catch(SQLException e) {
			e.printStackTrace();//查询可能出现空指针异常，打印异常
		}
		return courseList;
	}	
	
	
	
	
	
	public List<Course> noselectCourse(int stu_id){
		List<Course> courseList = new ArrayList<>();
		Connection conn = JdbcUtils.getConnection();//连接数据库
		String sql = "select * from course where course_id not in (select course_id from choice where stu_id="+stu_id+" );";
		
		try {
			/*
			PreparedStatement是用来执行SQL查询语句的API之一，Java提供了 Statement、PreparedStatement和
			CallableStatement三种方式来执行查询语句，其中 Statement 用于通用查询
			PreparedStatement 用于执行参数化查询，而 CallableStatement则是用于存储过程。
			*/
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery(); //ResultSet类是一种数据库查询结果存储类;
			while(rst.next()) {
				Course course = new Course();
				course.setCourse_id(rst.getInt("course_id"));
				course.setCourse_name(rst.getString("course_name"));
				course.setCourse_tea(rst.getString("course_tea"));
				course.setCourse_hour(rst.getInt("course_hour"));
				course.setCourse_mark(rst.getFloat("course_mark"));
				course.setCourse_time(rst.getString("course_time"));
				course.setCourse_place(rst.getString("course_place"));
				courseList.add(course);
			}
			rst.close();//关闭结果集，减少资源使用，关闭顺序和创建相反
			pst.close();//关闭API
		}catch(SQLException e) {
			e.printStackTrace();//查询可能出现空指针异常，打印异常
		}
		return courseList;
	}	
	
	//添加课程
	public void addCourse(Course course) { 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JdbcUtils.getConnection();
			
			String sql = "insert into course(course_id,course_name,course_tea,course_hour,course_mark,course_time,course_place)values(?,?,?,?,?,?,?);";
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, course.getCourse_id());
			pstmt.setString(2, course.getCourse_name());
			pstmt.setString(3, course.getCourse_tea());
			pstmt.setInt(4, course.getCourse_hour());
			pstmt.setFloat(5, course.getCourse_mark());
			pstmt.setString(6, course.getCourse_time());
			pstmt.setString(7, course.getCourse_place());
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//修改课程信息
	public void updateCourse(Course course) {
		Connection conn = JdbcUtils.getConnection();
		String sql = "update course set course_name=?,course_tea=?,course_hour=?,course_mark=?,course_time=?,course_place=? where course_id=?;";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, course.getCourse_name());
			pst.setString(2, course.getCourse_tea());
			pst.setInt(3, course.getCourse_hour());
			pst.setFloat(4, course.getCourse_mark());
			pst.setString(5, course.getCourse_time());
			pst.setString(6, course.getCourse_place());
			pst.setInt(7, course.getCourse_id());
			/*pst.setInt(8, course.getCourse_id());*/
			
			pst.executeUpdate();
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//删除课程信息
	public void deleteCourse(int course_id) {
		Connection conn = JdbcUtils.getConnection();
		String sql = "delete from course where course_id=?;";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, course_id);
			pst.executeUpdate();
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//根据course_id查询课程
	public Course getCourseById(int course_id) {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from course where course_id="+course_id;
		Course course = new Course();
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				course.setCourse_id(rst.getInt("course_id"));
				course.setCourse_name(rst.getString("course_name"));
				course.setCourse_tea(rst.getString("course_tea"));
				course.setCourse_hour(rst.getInt("course_hour"));
				course.setCourse_mark(rst.getFloat("course_mark"));
				course.setCourse_time(rst.getString("course_time"));
				course.setCourse_place(rst.getString("course_place"));
			}
			rst.close();
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return course;
	}
	
	
}
