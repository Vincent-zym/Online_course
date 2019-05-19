package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Course;
import com.demo.dao.CourseDao;

@WebServlet("/list")
public class ListCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CourseDao courseDao = new CourseDao();
		List<Course> courseList = courseDao.selectCourse();
		req.setAttribute("courseList", courseList);//获取jsp传递的值
		req.getRequestDispatcher("listCourse.jsp").forward(req, resp);
	}

}
