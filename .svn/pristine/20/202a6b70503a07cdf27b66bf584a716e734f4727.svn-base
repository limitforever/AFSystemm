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

import cauc.edu.cn.common.RecordAssist;
import cauc.edu.cn.model.AFUserInfo;
import cauc.edu.cn.service.OperatorRecordServices;
import cauc.edu.cn.service.UserServices;


//web 3.0的新写法
@WebServlet("/UserModfiyServlet")
public class UserModfiyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		request.setCharacterEncoding("UTF-8");
	
		
		Integer userid = Integer.parseInt(request.getParameter("id"));
		AFUserInfo afuser = new AFUserInfo();
		afuser.setUserid(userid);
		UserServices userService = new UserServices();
		
		String usernum = request.getParameter("usernum");
		String username = request.getParameter("username");
//		String nonenpassword  = request.getParameter("nonenpassword");
		Integer age = Integer.parseInt(request.getParameter("age"));		
		String phonenum = request.getParameter("phonenum");
		String sex = request.getParameter("sex");
		
		afuser.setUsernum(usernum);
		afuser.setUsername(username);
//		afuser.setEnpassword((MD5Encrypted.DoEncrypt(nonenpassword)));
		afuser.setAge(age);
		afuser.setSex(sex);
		afuser.setPhonenum(phonenum);
	
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		
		boolean Verifyupdateuser = userService.UpdateUser(afuser);
		
		Map<String,String> map = new HashMap<String, String>();
		
		/*
		 * 记录用户的操作记录
		 */
		HttpSession session = request.getSession();
		AFUserInfo userInfo = (AFUserInfo) session.getAttribute("CURRENTLOGINUSER");
		
		RecordAssist recordAssist = new RecordAssist("修改用户"+ usernum +"的信息", userInfo);
		
		if(Verifyupdateuser)
		{
			OperatorRecordServices.AddOperatorRecord(recordAssist);
			map.put("resultMsg", "更新成功");
			writer.print(gson.toJson(map));
		}
		else
		{
			map.put("resultMsg", "fail");
			writer.print(gson.toJson(map));
		}	
	}
}
