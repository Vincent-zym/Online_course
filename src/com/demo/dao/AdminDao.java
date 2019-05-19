package com.demo.dao;

import java.sql.*;

import com.demo.Utils.JdbcUtils;//�������ݿ�
import com.demo.bean.Admin;//ʵ����

public class AdminDao {
	public Admin login(Integer adm_id, String adm_pwd) {  //��¼
		Admin adm = null;
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
		String sql = "select * from manager where adm_id=? and adm_pwd=?;";
		pstmt = (PreparedStatement) connection.prepareStatement(sql);
		// �������˼���û����������SQL�����ʺŴ�
		pstmt.setInt(1, adm_id);//����Ԥ����������;1�����һ������
		pstmt.setString(2, adm_pwd);
		resultSet = pstmt.executeQuery();// �õ����ݿ�Ĳ�ѯ���
		// �жϽ�����Ƿ���Ч
		if(resultSet.next()) {
			adm = new Admin();
			adm.setAdm_id(resultSet.getInt("adm_id"));
			adm.setAdm_pwd(resultSet.getString("adm_pwd"));
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
	return adm;
	}
	
	//��� ע��
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