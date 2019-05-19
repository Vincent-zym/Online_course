package servlet;
//导入需要的各种包，其中在创建servlet时候后默认导入servlet相关包
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import com.demo.bean.Admin;
import com.demo.dao.AdminDao;

@WebServlet("/adm_login")
public class AdmLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int adm_id = Integer.valueOf(request.getParameter("adm_id"));//获取用户名和密码
		String adm_pwd = request.getParameter("adm_pwd");
		AdminDao admintDao=new AdminDao(); //创建adminDao实例
		Admin admin=admintDao.login(adm_id, adm_pwd);
		if(admin!=null) {//判断student是否为空
			//转发到LoginSuccess.jsp页面,getRequestDispatcher()是请求转发
			request.getRequestDispatcher("listCourse.jsp").forward(request, response);
		}else {//登录失败
			request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
		}
	}
}
