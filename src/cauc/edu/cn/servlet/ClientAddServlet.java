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

@WebServlet("/ClientAddServlet")

public class ClientAddServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		/**
		 * 获取网页中的数据
		 * 
		 */
		request.setCharacterEncoding("UTF-8");
		//Integer clientid1 =Integer.parseInt(request.getParameter("clientid"));
		String clientcid = request.getParameter("clientcid");
		String clientnum = request.getParameter("clientnum");
		ClientInfo client = new ClientInfo();
		
		//client.setClientid(clientid1);
		client.setClientcid(clientcid);
		client.setClientnum(clientnum);
		
		
		ClientServices ClientService = new ClientServices();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		boolean VerifyAddClient = ClientService.AddClient(client);
		Map<String,String> map = new HashMap<String, String>();
		

		/*
		 * 记录用户的操作记录
		 */
		HttpSession session = request.getSession();
		AFUserInfo userInfo = (AFUserInfo) session.getAttribute("CURRENTLOGINUSER");
		
		RecordAssist recordAssist = new RecordAssist("增加设备"+clientnum, userInfo);
		
		if(VerifyAddClient)
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
