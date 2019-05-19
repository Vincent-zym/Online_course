package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Course;
import com.demo.bean.Student;
import com.demo.dao.CourseDao;

@WebServlet("/selectCourse")
public class SelectCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CourseDao courseDao = new CourseDao();
		Student student=(Student) req.getSession().getAttribute("student");
		int stu_id=student.getStu_id();
		List<Course> courseList = courseDao.noselectCourse(stu_id);
		req.setAttribute("courseList", courseList);//获取jsp传递的值
		req.getRequestDispatcher("selectCourse.jsp").forward(req, resp);
	}

}
