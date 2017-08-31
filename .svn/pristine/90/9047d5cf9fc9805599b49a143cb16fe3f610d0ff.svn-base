package cauc.edu.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cauc.edu.cn.model.PaginationInfo;
import cauc.edu.cn.service.OilWorkerServices;

import com.google.gson.Gson;

@WebServlet("/GetAllOilWorkerServlet")
public class GetAllOilWorkerServlet extends HttpServlet
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
		OilWorkerServices workerService = new OilWorkerServices();
		PaginationInfo PaginationInfo = null;
		try 
		{
			PaginationInfo = workerService.queryWorkerCountByPagination(1,99,null);
		} 
		catch (NoSuchFieldException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();
		String json = gson.toJson(PaginationInfo.getBaseInfoList());
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(json);		
	}
}
