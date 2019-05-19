package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Course;
import com.demo.bean.Select;
import com.demo.bean.Student;
import com.demo.dao.SelectDao;

@WebServlet("/selectPreview")
public class SelectPreviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student=(Student) req.getSession().getAttribute("student");
		int stu_id=student.getStu_id();
		SelectDao selectDao = new SelectDao();
		List<Course> courseList=selectDao.select(stu_id);
		req.setAttribute("courseList", courseList);//获取jsp传递的值
		req.getRequestDispatcher("selectPreview.jsp").forward(req, resp);
	}

}
