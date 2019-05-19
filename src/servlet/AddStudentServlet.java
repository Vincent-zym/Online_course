package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Student;
import com.demo.dao.StudentDao;


@WebServlet("/addStu")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("addStu.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//String name = request.getparameter("name"); 
		int stu_id = Integer.valueOf(req.getParameter("stu_id"));
		String stu_name = req.getParameter("stu_name");
		String stu_pwd = req.getParameter("stu_pwd");
		
		Student student = new Student();
		student.setStu_id(stu_id);
		student.setStu_name(stu_name);
		student.setStu_pwd(stu_pwd);
		
		StudentDao studentDao = new StudentDao();
		studentDao.addStudent(student);
		System.out.println("Ìí¼Ó³É¹¦");
		req.getRequestDispatcher("/listStu").forward(req, resp);
	}

}
