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
		
		//获取用户名和密码
		int stu_id = Integer.valueOf(request.getParameter("stu_id"));
		String stu_pwd = request.getParameter("stu_pwd");
		
		//获取userDao实例
		UserDao userDao=new UserDao(); 
		User user=userDao.login(stu_id, stu_pwd);
		
		//判断user是否为空
			if(user!=null) {
				//转发到LoginSuccess.jsp页面
				//getRequestDispatcher()是请求转发
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				//登录失败
				request.getRequestDispatcher("LoginFailed.jsp").forward(request, response);
			}
	}
}
