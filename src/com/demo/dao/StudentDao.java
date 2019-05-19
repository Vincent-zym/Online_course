package com.demo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.demo.Utils.JdbcUtils;//�������ݿ�
import com.demo.bean.Student;//ʵ����

public class StudentDao {
	public Student login(Integer stu_id, String stu_pwd) {  //��¼
		Student u = null;
		Connection connection = null;
		/*
		PreparedStatement������ִ��SQL��ѯ����API֮һ��Java�ṩ�� Statement��PreparedStatement��
		CallableStatement���ַ�ʽ��ִ�в�ѯ��䣬���� Statement ����ͨ�ò�ѯ
		PreparedStatement ����ִ�в�������ѯ���� CallableStatement�������ڴ洢���̡�
		*/
		PreparedStatement pstmt = null;//���β�ѯ���
		ResultSet resultSet=null;//ResultSet����һ�����ݿ��ѯ����洢��;
		
		try {//��ֵ���������ݿ���ܳ��ֿ�ָ���쳣����������׳�
		connection = JdbcUtils.getConnection();//�������ݿ�����ӷ������������ݿ⡣
		String sql = "select * from student where stu_id=? and stu_pwd=?;";
		pstmt = (PreparedStatement) connection.prepareStatement(sql);
		// �������˼���û����������SQL�����ʺŴ�
		pstmt.setInt(1, stu_id);//����Ԥ����������;1�����һ������
		pstmt.setString(2, stu_pwd);
		resultSet = pstmt.executeQuery();// �õ����ݿ�Ĳ�ѯ���
		// �жϽ�����Ƿ���Ч
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
			System.out.println("��¼�ɹ���");
		}else {
			System.out.println("�û������������");
		}
		resultSet.close();//�߼�������ر�����Դ�⣬������Դ���������ȴ����ĺ��
		pstmt.close();
		connection.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	return u;
	}
	
	//��� ע��
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
	
	//��ѯ����ѧ����Ϣ
	public List<Student> selectStudent(){
		List<Student> studentList = new ArrayList<>();
		Connection conn = JdbcUtils.getConnection();//�������ݿ�
		String sql = "select * from student;";
		
		try {
			/*
			PreparedStatement������ִ��SQL��ѯ����API֮һ��Java�ṩ�� Statement��PreparedStatement��
			CallableStatement���ַ�ʽ��ִ�в�ѯ��䣬���� Statement ����ͨ�ò�ѯ
			PreparedStatement ����ִ�в�������ѯ���� CallableStatement�������ڴ洢���̡�
			*/
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery(); //ResultSet����һ�����ݿ��ѯ����洢��;
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
			rst.close();//�رս������������Դʹ�ã��ر�˳��ʹ����෴
			pst.close();//�ر�API
		}catch(SQLException e) {
			e.printStackTrace();//��ѯ���ܳ��ֿ�ָ���쳣����ӡ�쳣
		}
		return studentList;
	}
	
	//ɾ��һ��ѧ����Ϣ	
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
		
	
	//����ѧ����Ϣ
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
	
	//����ѧ�Ų�ѯһ����¼
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