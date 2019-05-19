package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Student;
import com.demo.dao.StudentDao;

@WebServlet("/listStu")
public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao studentDao = new StudentDao();
		List<Student> studentList = studentDao.selectStudent();
		req.setAttribute("studentList", studentList);//获取jsp传递的值
		req.getRequestDispatcher("listStu.jsp").forward(req, resp);
	}
}
