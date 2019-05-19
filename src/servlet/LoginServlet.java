package servlet;
//������Ҫ�ĸ��ְ��������ڴ���servletʱ���Ĭ�ϵ���servlet��ذ�
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

//�����������Լ������ģ��õ������䵼��
import com.demo.bean.Student;
import com.demo.dao.StudentDao;

@WebServlet("/login")//����ע�⣬�˲����൱�ڶ������web.xml����servlet
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//��ȡ�û���������
		int stu_id = Integer.valueOf(request.getParameter("stu_id"));
		String stu_pwd = request.getParameter("stu_pwd");
		//����studentDaoʵ��
		StudentDao studentDao=new StudentDao(); 
		Student student=studentDao.login(stu_id, stu_pwd);
		
		
		/*String uname = request.getParameter("userName");  */
		request.getSession().setAttribute("student",student);//���û��������������Ự�ڼ�
		
		//�ж�student�Ƿ�Ϊ��
		if(student!=null) {
			//ת����LoginSuccess.jspҳ��,getRequestDispatcher()������ת��
			request.getRequestDispatcher("listStudent.jsp").forward(request, response);
		}else {//��¼ʧ��
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
