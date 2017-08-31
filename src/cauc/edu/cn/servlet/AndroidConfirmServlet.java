package cauc.edu.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cauc.edu.cn.model.FuelSheetInfo;
import cauc.edu.cn.service.UpdateFuelSheetStateServices;

import com.google.gson.Gson;

@WebServlet("/AndroidConfirmServlet")
public class AndroidConfirmServlet extends HttpServlet
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
		String message = request.getParameter("message");
		
		Gson gson = new Gson();
		Map map = gson.fromJson(message, Map.class);
		
		String fuelsheetnum = (String) map.get("fuelsheetnum");
		FuelSheetInfo fuelSheetInfo = new FuelSheetInfo();
		fuelSheetInfo.setFuelsheetnum(fuelsheetnum);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		if(fuelsheetnum!=null)
		{
			UpdateFuelSheetStateServices updateworkersheetStateService = new UpdateFuelSheetStateServices();		
			updateworkersheetStateService.UpdateworkersheetState_3(fuelSheetInfo);
			writer.println("0");	
		}
		else 
		{
			writer.println("0");
		}
	}
}
