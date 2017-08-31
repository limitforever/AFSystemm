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

import cauc.edu.cn.model.PaginationInfo;

import cauc.edu.cn.service.ClientServices;

import com.google.gson.Gson;

@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet{
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

		String chaxuntiaojian = request.getParameter("chaxuntiaojian");
		Gson gson = new Gson();
		Map fromJson = gson.fromJson(chaxuntiaojian, Map.class);
		String currentPageNumStr = request.getParameter("page");
		Integer rows = Integer.parseInt(request.getParameter("rows"));
		
		int currentPageNum = 1;
		if(currentPageNumStr!=null){
			//第一次进入查询页面的情况
			currentPageNum = Integer.parseInt(currentPageNumStr);
		}
		
		ClientServices ClientService = new ClientServices();
		
		PaginationInfo PaginationInfo = null;
		
		try 
		{
			PaginationInfo = ClientService.queryClientByPagination(currentPageNum,rows,fromJson);
		} 
		catch (NoSuchFieldException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Map<String, Object> easyUIDataGrid = new HashMap<String, Object>();
		easyUIDataGrid.put("total", PaginationInfo.getTotalCountNum());
		easyUIDataGrid.put("rows", PaginationInfo.getBaseInfoList());
		String json = gson.toJson(easyUIDataGrid);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(json);		
	}
}
