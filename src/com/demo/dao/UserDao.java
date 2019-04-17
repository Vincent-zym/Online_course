package com.demo.dao;

import java.sql.*;

import com.demo.Utils.JdbcUtils;
import com.demo.bean.User;

public class UserDao {
	public User login(Integer stu_id, String stu_pwd) {
		User u = null;
		//String SQL = "select * from user where stu_id=? and stu_pwd =? ";
		Connection connection = null;
		PreparedStatement pstmt = null;//���β�ѯ���
		ResultSet resultSet=null;
		
		//��ֵ
		try {
		connection = JdbcUtils.getConnection();
		String sql = "select * from student where stu_id=? and stu_pwd=?;";
		pstmt = (PreparedStatement) connection.prepareStatement(sql);
		// �������˼���û����������SQL�����ʺŴ�
		pstmt.setInt(1, stu_id);//����Ԥ����������;1�����һ������
		pstmt.setString(2, stu_pwd);
		resultSet = pstmt.executeQuery();// �õ����ݿ�Ĳ�ѯ���
		// �жϽ�����Ƿ���Ч
		if(resultSet.next()) {
			u = new User();
			u.setStu_id(resultSet.getInt("stu_id"));
			u.setStu_pwd(resultSet.getString("stu_pwd"));
			System.out.println("��¼�ɹ���");
		}else {
			System.out.println("�û������������");
		}
		resultSet.close();
		pstmt.close();
		connection.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	return u;
	}
	
	//��� ע��
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