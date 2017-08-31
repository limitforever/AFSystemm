package cauc.edu.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cauc.edu.cn.model.GisInfo;
import cauc.edu.cn.model.VehicleLogInfo;
import cauc.edu.cn.service.GisServices;
import cauc.edu.cn.service.VehicleLogServices;

import com.google.gson.Gson;

@WebServlet("/AndroidGisServlet")
public class AndroidGisServlet extends HttpServlet{

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

		String message = request.getParameter("message");
		
		Gson gson = new Gson();
		Map map = gson.fromJson(message, Map.class);
	
		String isfast = (String) map.get("isfast");
		String xposition  = (String) map.get("xposition");
		String yposition  = (String) map.get("yposition");
		String logtime = (String) map.get("logtime");
		String workeruserid = (String) map.get("workeruserid");
//		String fuelsheetnum = (String) map.get("fuelsheetnum");
		String speed = (String) map.get("speed");
		String vehiclenum = (String) map.get("vehiclenum");
		
		GisInfo gisInfo = new GisInfo();
		
		gisInfo.setLogtime(logtime);
		gisInfo.setXposition(Double.parseDouble(xposition));
		gisInfo.setYposition(Double.parseDouble(yposition));
		gisInfo.setVehiclenum(vehiclenum);
		gisInfo.setWorkeruserid(workeruserid);
		gisInfo.setSpeed(Double.parseDouble(speed));
		
		GisServices gisService = new GisServices();
		try {
			gisService.AddGisInfo(gisInfo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		VehicleLogInfo vehicleLogInfo = new VehicleLogInfo();
		VehicleLogServices vehicleLogService = new VehicleLogServices();
		
		if (isfast.equals("ture"))
		{
			vehicleLogInfo.setLogtime(logtime);
			vehicleLogInfo.setXposition(Double.parseDouble(xposition));
			vehicleLogInfo.setYposition(Double.parseDouble(yposition));
			vehicleLogInfo.setVehiclenum(vehiclenum);
			vehicleLogInfo.setWorkeruserid(workeruserid);
			vehicleLogInfo.setSpeed(Double.parseDouble(speed));
			try {
				vehicleLogService.AddVehicleLogInfo(vehicleLogInfo);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		PrintWriter writer = response.getWriter();
		writer.println("0");	
	}
}
