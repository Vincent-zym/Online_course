package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.CourseDao;

@WebServlet("/delete")  //注解，在xml里进行注册
public class DeleteCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int course_id = Integer.parseInt(req.getParameter("course_id"));
		CourseDao courseDao = new CourseDao();
		courseDao.deleteCourse(course_id);
		req.getRequestDispatcher("/list").forward(req, resp);
	}

}
