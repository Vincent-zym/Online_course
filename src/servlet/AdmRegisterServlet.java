package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�����������Լ������ģ��õ������䵼��
import com.demo.bean.Admin;
import com.demo.dao.AdminDao;

@WebServlet("/adm_reg")//����ע�⣬�˲����൱�ڶ������web.xml����servlet
public class AdmRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			//��ȡ�û��������룬getParameter�ֶκ�form����name����������ͬ,ע��intҪ�ð�װ��
			int adm_id = Integer.valueOf(request.getParameter("adm_id"));
			String adm_pwd = request.getParameter("adm_pwd");
			String adm_tel = request.getParameter("adm_tel");
			
			Admin admin = new Admin();//����ʵ�壬�������Խ��д�ֵ
			admin.setAdm_id(adm_id);
			admin.setAdm_pwd(adm_pwd);
			admin.setAdm_tel(adm_tel);
			AdminDao adminDao=new AdminDao();//��������
			adminDao.addAdmin(admin);//����AdminDao�еķ���
			System.out.println("ע��ɹ�");
			//��¼�ɹ�����ת
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
	 }
}
