package servlet;
//������Ҫ�ĸ��ְ��������ڴ���servletʱ���Ĭ�ϵ���servlet��ذ�
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
		int adm_id = Integer.valueOf(request.getParameter("adm_id"));//��ȡ�û���������
		String adm_pwd = request.getParameter("adm_pwd");
		AdminDao admintDao=new AdminDao(); //����adminDaoʵ��
		Admin admin=admintDao.login(adm_id, adm_pwd);
		if(admin!=null) {//�ж�student�Ƿ�Ϊ��
			//ת����LoginSuccess.jspҳ��,getRequestDispatcher()������ת��
			request.getRequestDispatcher("listCourse.jsp").forward(request, response);
		}else {//��¼ʧ��
			request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
		}
	}
}
