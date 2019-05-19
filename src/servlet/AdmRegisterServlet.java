package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//这两个包是自己创建的，用到，对其导入
import com.demo.bean.Admin;
import com.demo.dao.AdminDao;

@WebServlet("/adm_reg")//进行注解，此操作相当于对其进行web.xml配置servlet
public class AdmRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			//获取用户名和密码，getParameter字段和form表单中name属性设置相同,注意int要用包装类
			int adm_id = Integer.valueOf(request.getParameter("adm_id"));
			String adm_pwd = request.getParameter("adm_pwd");
			String adm_tel = request.getParameter("adm_tel");
			
			Admin admin = new Admin();//创建实体，并对属性进行传值
			admin.setAdm_id(adm_id);
			admin.setAdm_pwd(adm_pwd);
			admin.setAdm_tel(adm_tel);
			AdminDao adminDao=new AdminDao();//创建操作
			adminDao.addAdmin(admin);//调用AdminDao中的方法
			System.out.println("注册成功");
			//登录成功后跳转
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
	 }
}
