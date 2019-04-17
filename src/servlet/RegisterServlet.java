package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.User;
import com.demo.dao.UserDao;

public class RegisterServlet extends HttpServlet {

	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			int stu_id = Integer.valueOf(request.getParameter("stu_id"));
			String stu_pwd = request.getParameter("stu_pwd");
			String stu_tel = request.getParameter("stu_tel");//注意int要用包装类
			User user = new User();
			user.setStu_id(stu_id);
			user.setStu_pwd(stu_pwd);
			user.setStu_tel(stu_tel);
			UserDao userDao=new UserDao();
			userDao.addUser(user);
			System.out.println("注册成功");
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
	 }
}
