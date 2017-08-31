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
import cauc.edu.cn.model.VehicleInfo;
import cauc.edu.cn.service.OperatorRecordServices;
import cauc.edu.cn.service.VehicleSerives;

import com.google.gson.Gson;

@WebServlet("/VehicleModfiyServlet")
public class VehicleModfiyServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		request.setCharacterEncoding("UTF-8");
	
		Integer vehicleid = Integer.parseInt(request.getParameter("id"));
		VehicleInfo vehicle = new VehicleInfo();
		vehicle.setVehicleid(vehicleid);
		VehicleSerives vehicleSerive = new VehicleSerives();
		
		String vehiclenum = request.getParameter("vehiclenum");
		String vehiclelicence = request.getParameter("vehiclelicence");
		String vehiclemodel = request.getParameter("vehiclemodel");
		
		vehicle.setVehicleid(vehicleid);
		vehicle.setVehiclenum(vehiclenum);
		vehicle.setVehiclelicence(vehiclelicence);
		vehicle.setVehiclemodel(vehiclemodel);
	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
	
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		
		boolean Verifyupdatevehicle = vehicleSerive.UpdateVehicle(vehicle);
		
		Map<String,String> map = new HashMap<String, String>();
		
		/*
		 * 记录用户的操作记录
		 */
		HttpSession session = request.getSession();
		AFUserInfo userInfo = (AFUserInfo) session.getAttribute("CURRENTLOGINUSER");
		
		RecordAssist recordAssist = new RecordAssist("修改车辆"+vehiclenum+"的信息", userInfo);
		
		if(Verifyupdatevehicle)
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
