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

import com.google.gson.Gson;

import cauc.edu.cn.common.MD5Encrypted;
import cauc.edu.cn.model.AFUserInfo;
import cauc.edu.cn.service.UserServices;




/**
 * Servlet implementation class UpdateCarServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		request.setCharacterEncoding("utf-8");
		String usernum = request.getParameter("usernum");
		String enpassword = request.getParameter("pwd");
		String username = request.getParameter("username");
		String sex = request.getParameter("sex");
		Integer age = Integer.parseInt(request.getParameter("age"));	
		String phonenum = request.getParameter("phonenum");
	
		AFUserInfo aFUserInfo = new AFUserInfo();
		aFUserInfo.setUsernum(usernum);
		aFUserInfo.setUsername(username);	
		aFUserInfo.setEnpassword((MD5Encrypted.DoEncrypt(enpassword)));
		aFUserInfo.setAge(age);
		aFUserInfo.setSex(sex);
		aFUserInfo.setPhonenum(phonenum);
		
		UserServices userServices = new UserServices();
		boolean Verifyupdateuser = userServices.UpdateUserPSW(aFUserInfo);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		request.setAttribute("usernum", aFUserInfo);
		
		if(Verifyupdateuser)
		{
			writer.print("<script>alert('更新成功！');window.location.href='Index.jsp';</script>");
		}else{
			writer.print("<script>alert('更新失败！');window.location.href='Index.jsp';</script>");
		}
		
	}

}
