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

import cauc.edu.cn.common.RecordAssist;
import cauc.edu.cn.model.AFUserInfo;
import cauc.edu.cn.model.ClientInfo;
import cauc.edu.cn.service.ClientServices;
import cauc.edu.cn.service.OperatorRecordServices;

import com.google.gson.Gson;

@WebServlet("/ClientModfiyServlet")
public class ClientModfiyServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		request.setCharacterEncoding("UTF-8");
		Integer clientid = Integer.parseInt(request.getParameter("id"));
		System.out.print(clientid);
		ClientInfo Client = new ClientInfo();
		Client.setClientid(clientid);
		ClientServices ClientService = new ClientServices();
		
		//Integer clientid1 =Integer.parseInt(request.getParameter("clientid"));
		String clientcid = request.getParameter("clientcid");
		String clientnum = request.getParameter("clientnum");
		
		//Client.setClientid(clientid1);
		Client.setClientcid(clientcid);
		Client.setClientnum(clientnum);
		
	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		
		boolean ClientupdateClient = ClientService.UpdateClient(Client);
		
		Map<String,String> map = new HashMap<String, String>();
		
		/*
		 * 记录用户的操作记录
		 */
		HttpSession session = request.getSession();
		AFUserInfo userInfo = (AFUserInfo) session.getAttribute("CURRENTLOGINUSER");	
		RecordAssist recordAssist = new RecordAssist("更新设备"+clientnum, userInfo);
		
		if(ClientupdateClient)
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
