package com.demo.dao;

import java.sql.*;
import java.util.*;

import com.demo.bean.Course;
import com.demo.bean.Select;
import com.demo.Utils.JdbcUtils;

public class SelectDao {
	
	//添加到选课表
	public void addSelect(Select select) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = JdbcUtils.getConnection();
			
			String sql = "insert into choice(stu_id,course_id) values(?,?);";
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, select.getStu_id());
			pstmt.setInt(2, select.getCourse_id());
			
			pstmt.executeUpdate();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//查询自己已选
	public List<Course> select(int stu_id){
		List<Course> courseList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select course_id,course_name,course_tea,course_time,course_place from course where course_id in (select course_id from choice where stu_id="+stu_id+" );";
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()) {
				Course course = new Course();
				course.setCourse_id(rst.getInt("course_id"));
				course.setCourse_name(rst.getString("course_name"));
				course.setCourse_tea(rst.getString("course_tea"));
				course.setCourse_time(rst.getString("course_time"));
				course.setCourse_place(rst.getString("course_place"));
				
				courseList.add(course);
			}
			rst.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return courseList;
	}
	
	
}
