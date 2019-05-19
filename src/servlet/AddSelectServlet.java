package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Select;
import com.demo.bean.Student;
import com.demo.dao.SelectDao;


@WebServlet("/addSelect")
public class AddSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//String name = request.getparameter("name");
		int course_id = Integer.valueOf(req.getParameter("course_id"));
		//System.out.println(course_id);//�����Ƿ��ȡ�ɹ�
		Student student=(Student) req.getSession().getAttribute("student");//������Ϣ��ȡ��Ҫ��session��
		int stu_id=student.getStu_id();
		Select select = new Select();
		select.setStu_id(stu_id);
		select.setCourse_id(course_id);
		
		
		SelectDao selectDao = new SelectDao();
		selectDao.addSelect(select);
		
		System.out.println("��ӳɹ�");
		resp.sendRedirect("/selectCourse");
	}

}
