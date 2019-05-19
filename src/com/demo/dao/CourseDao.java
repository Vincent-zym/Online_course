package com.demo.dao;

//�����
import java.sql.*;
import java.util.*;

import com.demo.bean.Course;
import com.demo.Utils.JdbcUtils;

public class CourseDao {

	//��ѯ���пγ���Ϣ
	public List<Course> selectCourse(){
		List<Course> courseList = new ArrayList<>();
		Connection conn = JdbcUtils.getConnection();//�������ݿ�
		String sql = "select * from course;";
		
		try {
			/*
			PreparedStatement������ִ��SQL��ѯ����API֮һ��Java�ṩ�� Statement��PreparedStatement��
			CallableStatement���ַ�ʽ��ִ�в�ѯ��䣬���� Statement ����ͨ�ò�ѯ
			PreparedStatement ����ִ�в�������ѯ���� CallableStatement�������ڴ洢���̡�
			*/
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery(); //ResultSet����һ�����ݿ��ѯ����洢��;
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
			rst.close();//�رս������������Դʹ�ã��ر�˳��ʹ����෴
			pst.close();//�ر�API
		}catch(SQLException e) {
			e.printStackTrace();//��ѯ���ܳ��ֿ�ָ���쳣����ӡ�쳣
		}
		return courseList;
	}	
	
	
	
	
	
	public List<Course> noselectCourse(int stu_id){
		List<Course> courseList = new ArrayList<>();
		Connection conn = JdbcUtils.getConnection();//�������ݿ�
		String sql = "select * from course where course_id not in (select course_id from choice where stu_id="+stu_id+" );";
		
		try {
			/*
			PreparedStatement������ִ��SQL��ѯ����API֮һ��Java�ṩ�� Statement��PreparedStatement��
			CallableStatement���ַ�ʽ��ִ�в�ѯ��䣬���� Statement ����ͨ�ò�ѯ
			PreparedStatement ����ִ�в�������ѯ���� CallableStatement�������ڴ洢���̡�
			*/
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery(); //ResultSet����һ�����ݿ��ѯ����洢��;
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
			rst.close();//�رս������������Դʹ�ã��ر�˳��ʹ����෴
			pst.close();//�ر�API
		}catch(SQLException e) {
			e.printStackTrace();//��ѯ���ܳ��ֿ�ָ���쳣����ӡ�쳣
		}
		return courseList;
	}	
	
	//��ӿγ�
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
	
	
	//�޸Ŀγ���Ϣ
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
	
	
	//ɾ���γ���Ϣ
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
	
	
	//����course_id��ѯ�γ�
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
