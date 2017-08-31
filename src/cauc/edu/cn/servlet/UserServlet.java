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

import cauc.edu.cn.model.PaginationInfo;
import cauc.edu.cn.service.UserServices;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet
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
		
		UserServices userService = new UserServices();
		PaginationInfo PaginationInfo = null;
		try 
		{
			PaginationInfo = userService.queryUserByPagination(currentPageNum,rows,fromJson);
		} 
		catch (NoSuchFieldException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * 在网页中显示后台查询的结果，需要将结果集放入request作用域
		 * session作用域的生命周期是整个服务器运行的时候，除非手动清除，否则一直存在
		 * request作用域的生命周期是由跳转网页前至跳转网页后响应结束
		 * 查询结果一定不要放到session
		 * 
		 */
		
//		//结果集存入request
//		request.setAttribute("resultData", PaginationInfo.getBaseInfoList());
//		//当前页存入request
//		request.setAttribute("currentPageNum", currentPageNum);
//		//当前总页数存入request
//		request.setAttribute("totalPageNum", PaginationInfo.getTotalPageNum());
//
//		request.getRequestDispatcher("/queryWorkers.jsp").forward(request, response);
//		
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
