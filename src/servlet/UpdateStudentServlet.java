package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Student;
import com.demo.dao.StudentDao;

@WebServlet("/updateStu")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int stu_id = Integer.parseInt(req.getParameter("stu_id"));
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.getStudentById(stu_id);
		/*req.setAttribute("student", student);*/
		req.getSession().setAttribute("student", student);
		req.getRequestDispatcher("updateStudent.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Student student = new Student();
		
		int stu_id = Integer.parseInt(req.getParameter("stu_id"));
		String stu_name = req.getParameter("stu_name");
		String stu_pwd = req.getParameter("stu_pwd");
		String stu_sex = req.getParameter("stu_sex");
		String stu_grade = req.getParameter("stu_grade");
		String stu_tel = req.getParameter("stu_tel");
		String stu_major = req.getParameter("stu_major");
		String stu_place = req.getParameter("stu_place");
		String stu_nation = req.getParameter("stu_nation");
		student.setStu_id(stu_id);
		student.setStu_name(stu_name);
		student.setStu_pwd(stu_pwd);
		student.setStu_sex(stu_sex);
		student.setStu_grade(stu_grade);
		student.setStu_tel(stu_tel);
		student.setStu_major(stu_major);
		student.setStu_place(stu_place);
		student.setStu_nation(stu_nation);
		
		StudentDao studentDao = new StudentDao();
		studentDao.updateStudent(student);
		req.getSession().setAttribute("student", student);
		req.getRequestDispatcher("/listStudent.jsp").forward(req, resp);
	}

}
