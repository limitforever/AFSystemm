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
import cauc.edu.cn.service.WaitingForWorkSheetServices;

import com.google.gson.Gson;

@WebServlet("/WorkOrderSheetServlet")
public class WorkOrderSheetServlet extends HttpServlet
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
		String chaxuntiaojian = request.getParameter("chaxuntiaojian3");
		
		Gson gson = new Gson();
		Map fromJson = gson.fromJson(chaxuntiaojian, Map.class);
		String currentPageNumStr = request.getParameter("page");
		Integer rows = Integer.parseInt(request.getParameter("rows"));
		
		int currentPageNum = 1;
		if(currentPageNumStr!=null){
			//第一次进入查询页面的情况
			currentPageNum = Integer.parseInt(currentPageNumStr);
		}
		
		WaitingForWorkSheetServices waitingForWorkSheetServices = new WaitingForWorkSheetServices();
		PaginationInfo paginationInfo = null;
		try 
		{
			paginationInfo = waitingForWorkSheetServices.queryWaitingForWorkSheetByPagination(currentPageNum,rows,fromJson);
		} 
		catch (NoSuchFieldException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map<String, Object> easyUIDataGrid = new HashMap<String, Object>();
		easyUIDataGrid.put("total", paginationInfo.getTotalCountNum());
		easyUIDataGrid.put("rows", paginationInfo.getBaseInfoList());
		String json = gson.toJson(easyUIDataGrid);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(json);		
	}
}
