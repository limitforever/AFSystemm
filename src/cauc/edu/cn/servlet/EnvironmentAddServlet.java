package cauc.edu.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cauc.edu.cn.common.RecordAssist;
import cauc.edu.cn.model.AFUserInfo;
import cauc.edu.cn.model.EnvironmentInfo;
import cauc.edu.cn.service.EnvironmentServices;
import cauc.edu.cn.service.OperatorRecordServices;

import com.google.gson.Gson;

@WebServlet("/EnvironmentAddServlet")

public class EnvironmentAddServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		request.setCharacterEncoding("UTF-8");
		
		Double temperature = Double.parseDouble(request.getParameter("temperature"));
		Double fueldensity = Double.parseDouble(request.getParameter("fueldensity"));	
		String messuredtime = request.getParameter("messuredtime");
		
        EnvironmentInfo environmentInfo = new EnvironmentInfo();
		
        environmentInfo.setTemperature(temperature);
        environmentInfo.setFueldensity(fueldensity);
        environmentInfo.setMessuredtime(messuredtime);
        

        
        
        EnvironmentServices environmentService = new EnvironmentServices();
        
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		boolean Verifyaddenvironment = false;
		try {
			Verifyaddenvironment = environmentService.AddEnvironment(environmentInfo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,String> map = new HashMap<String, String>();
		
		/*
		 * 记录用户的操作记录
		 */
		HttpSession session = request.getSession();
		AFUserInfo userInfo = (AFUserInfo) session.getAttribute("CURRENTLOGINUSER");
		
		RecordAssist recordAssist = new RecordAssist("增加环境信息", userInfo);
		
		if(Verifyaddenvironment)
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
//			MessageBox.ShowMessageBoxJMP("注册失败！", "UsersManage.jsp", response);
		}
	}

}
