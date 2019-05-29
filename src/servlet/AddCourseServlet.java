package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Course;
import com.demo.dao.CourseDao;


@WebServlet("/add")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("addCourse.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//String name = request.getparameter("name"); 
		int course_id = Integer.valueOf(req.getParameter("course_id"));
		String course_name = req.getParameter("course_name");
		String course_tea = req.getParameter("course_tea");
		int course_hour = Integer.valueOf(req.getParameter("course_hour"));
		float course_mark = Float.valueOf(req.getParameter("course_mark"));
		String course_term = req.getParameter("course_term");
		String course_node = req.getParameter("course_node");
		String course_week = req.getParameter("course_week");
		String course_time = req.getParameter("course_time");
		String course_place = req.getParameter("course_place");
		
		Course course = new Course();
		course.setCourse_id(course_id);
		course.setCourse_name(course_name);
		course.setCourse_tea(course_tea);
		course.setCourse_hour(course_hour);
		course.setCourse_mark(course_mark);
		course.setCourse_term(course_term);
		course.setCourse_node(course_node);
		course.setCourse_week(course_week);
		course.setCourse_time(course_time);
		course.setCourse_place(course_place);
		
		CourseDao courseDao = new CourseDao();
		courseDao.addCourse(course);
		System.out.println("Ìí¼Ó³É¹¦");
		req.getRequestDispatcher("/list").forward(req, resp);
	}

}
