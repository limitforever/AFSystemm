package cauc.edu.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cauc.edu.cn.common.MD5Encrypted;
import cauc.edu.cn.common.RecordAssist;
import cauc.edu.cn.model.AFUserInfo;
import cauc.edu.cn.service.OperatorRecordServices;
import cauc.edu.cn.service.UserServices;


/**
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		/**
		 * 获取网页中的数据
		 * 员工编号，姓名，密码，年龄，性别，电话号码
		 */
		request.setCharacterEncoding("UTF-8");
		String usernum = request.getParameter("usernum");
		String username = request.getParameter("username");
		Integer age = Integer.parseInt(request.getParameter("age"));		
		String phonenum = request.getParameter("phonenum");
		String sex = request.getParameter("sex");
		
		AFUserInfo afuser = new AFUserInfo();
		
		afuser.setUsernum(usernum);
		afuser.setUsername(username);
		afuser.setEnpassword((MD5Encrypted.DoEncrypt("111111")));
		afuser.setAge(age);
		afuser.setSex(sex);
		afuser.setPhonenum(phonenum);
		
		
		
		UserServices userService = new UserServices();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		boolean Verifyadduser = userService.AddUser(afuser);
		Map<String,String> map = new HashMap<String, String>();
		
		/**
		 * 记录用户操作记录
		 */
		HttpSession session = request.getSession();
		AFUserInfo userInfo = (AFUserInfo) session.getAttribute("CURRENTLOGINUSER");
		
		RecordAssist recordAssist = new RecordAssist("添加用户"+usernum, userInfo);
		if(Verifyadduser)
		{
			OperatorRecordServices.AddOperatorRecord(recordAssist);
			map.put("resultMsg", "ok");
			writer.print(gson.toJson(map));
//			MessageBox.ShowMessageBoxJMP("注册成功！", "UsersManage.jsp", response);
		}
		else
		{
			map.put("resultMsg", "fail");
			//失败
			writer.print(gson.toJson(map));
//			MessageBox.ShowMessageBoxJMP("注册失败！", "UsersManage.jsp", response);
		}
	}

}

