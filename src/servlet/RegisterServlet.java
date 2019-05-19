package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Student;
import com.demo.dao.StudentDao;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			int stu_id = Integer.valueOf(request.getParameter("stu_id"));
			String stu_pwd = request.getParameter("stu_pwd");
			String stu_tel = request.getParameter("stu_tel");//注意int要用包装类
			
			
			Student student = new Student();
			student.setStu_id(stu_id);
			student.setStu_pwd(stu_pwd);
			student.setStu_tel(stu_tel);
			StudentDao studentDao=new StudentDao();
			studentDao.addStudent(student);
			System.out.println("注册成功");
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
	 }
}
