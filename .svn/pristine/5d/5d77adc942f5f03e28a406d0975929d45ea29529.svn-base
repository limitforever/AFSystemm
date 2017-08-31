package cauc.edu.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import cauc.edu.cn.model.OilWorkerInfo;
import cauc.edu.cn.service.OperatorRecordServices;
import cauc.edu.cn.service.OilWorkerServices;


/**
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/OilWorkerAddServlet")
public class OilWorkerAddServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		/**
		 * 获取网页中的数据
		 * 员工编号，姓名，密码，年龄，性别，电话号码
		 */
		request.setCharacterEncoding("UTF-8");
		String workeruserid = request.getParameter("workeruserid");
		String workerusername = request.getParameter("workerusername");
		Integer age = Integer.parseInt(request.getParameter("age"));		
		String phonenum = request.getParameter("phonenum");
		String sex = request.getParameter("sex");
		
		OilWorkerInfo oilworker = new OilWorkerInfo();
		
		oilworker.setWorkeruserid(workeruserid);
		oilworker.setWorkerusername(workerusername);
		oilworker.setWorkerenpassword((MD5Encrypted.DoEncrypt("111111")));
		oilworker.setAge(age);
		oilworker.setSex(sex);
		oilworker.setPhonenum(phonenum);
		
		
		OilWorkerServices workerService = new OilWorkerServices();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		boolean Verifyadduser = workerService.AddWorker(oilworker);
		Map<String,String> map = new HashMap<String, String>();
		
		/*
		 * 记录用户的操作记录
		 */
		HttpSession session = request.getSession();
		AFUserInfo userInfo = (AFUserInfo) session.getAttribute("CURRENTLOGINUSER");
		
		RecordAssist recordAssist = new RecordAssist("添加加油员" + workeruserid, userInfo);
		
		if(Verifyadduser)
		{
			
			OperatorRecordServices.AddOperatorRecord(recordAssist);
			map.put("resultMsg", "ok");
			writer.print(gson.toJson(map));
		}
		else
		{
			map.put("resultMsg", "fail");
			//失败
			writer.print(gson.toJson(map));
		}
	}

}


