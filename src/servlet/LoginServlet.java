package servlet;
//导入需要的各种包，其中在创建servlet时候后默认导入servlet相关包
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

//这两个包是自己创建的，用到，对其导入
import com.demo.bean.Student;
import com.demo.dao.StudentDao;

@WebServlet("/login")//进行注解，此操作相当于对其进行web.xml配置servlet
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取用户名和密码
		int stu_id = Integer.valueOf(request.getParameter("stu_id"));
		String stu_pwd = request.getParameter("stu_pwd");
		//创建studentDao实例
		StudentDao studentDao=new StudentDao(); 
		Student student=studentDao.login(stu_id, stu_pwd);
		
		
		/*String uname = request.getParameter("userName");  */
		request.getSession().setAttribute("student",student);//将用户名保存在整个会话期间
		
		//判断student是否为空
		if(student!=null) {
			//转发到LoginSuccess.jsp页面,getRequestDispatcher()是请求转发
			request.getRequestDispatcher("listStudent.jsp").forward(request, response);
		}else {//登录失败
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
