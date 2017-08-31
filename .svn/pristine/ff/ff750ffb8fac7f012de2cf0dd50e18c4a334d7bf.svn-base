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

import cauc.edu.cn.common.MD5Encrypted;
import cauc.edu.cn.common.RecordAssist;
import cauc.edu.cn.model.AFUserInfo;
import cauc.edu.cn.service.OperatorRecordServices;
import cauc.edu.cn.service.UserServices;

import com.google.gson.Gson;

@WebServlet("/UserResetPasswordServlet")
public class UserResetPasswordServlet extends HttpServlet
{

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
		
		afuser.setEnpassword((MD5Encrypted.DoEncrypt("111111")));
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		
		boolean Verifyupdateuserpassword = userService.UpdateUserpassword(afuser);
		
		/*
		 * 记录用户的操作记录
		 */
		HttpSession session = request.getSession();
		AFUserInfo userInfo = (AFUserInfo) session.getAttribute("CURRENTLOGINUSER");
		
		RecordAssist recordAssist = new RecordAssist("修改用户"+ userid +"的密码", userInfo);
		
		Map<String,String> map = new HashMap<String, String>();
		if(Verifyupdateuserpassword)
		{
			OperatorRecordServices.AddOperatorRecord(recordAssist);
			map.put("resultMsg", "ok");
			writer.print(gson.toJson(map));
		}
		else
		{
			map.put("resultMsg", "fail");
			writer.print(gson.toJson(map));
		}	
	}
}
