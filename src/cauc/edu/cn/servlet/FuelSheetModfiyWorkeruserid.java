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

import cauc.edu.cn.model.FuelSheetInfo;
import cauc.edu.cn.service.UpdateFuelSheetStateServices;


@WebServlet("/FuelSheetModfiyWorkeruserid")
public class FuelSheetModfiyWorkeruserid extends HttpServlet
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
		String workeruserid = request.getParameter("Workeruserid");
		System.out.println(workeruserid);
		Integer fuelsheetid = Integer.parseInt(request.getParameter("fuelsheetid"));
		System.out.println(fuelsheetid);
		
		
		FuelSheetInfo fuelSheetInfo = new FuelSheetInfo();
		fuelSheetInfo.setFuelsheetid(fuelsheetid);
		fuelSheetInfo.setWorkeruserid(workeruserid);
		
		UpdateFuelSheetStateServices updateFuelSheetStateServices = new UpdateFuelSheetStateServices();
		
		updateFuelSheetStateServices.UpdateOilWorkeruserid(fuelSheetInfo);
		response.sendRedirect(request.getContextPath() + "/Index.jsp");
		
	}//doPost()

}
