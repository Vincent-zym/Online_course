package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import javax.servlet.*;

import com.demo.bean.*;
import com.demo.dao.*;

public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//��ȡ�û���������
		int stu_id = Integer.valueOf(request.getParameter("stu_id"));
		String stu_pwd = request.getParameter("stu_pwd");
		
		//��ȡuserDaoʵ��
		UserDao userDao=new UserDao(); 
		User user=userDao.login(stu_id, stu_pwd);
		
		//�ж�user�Ƿ�Ϊ��
			if(user!=null) {
				//ת����LoginSuccess.jspҳ��
				//getRequestDispatcher()������ת��
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				//��¼ʧ��
				request.getRequestDispatcher("LoginFailed.jsp").forward(request, response);
			}
	}
}
