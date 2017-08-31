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

@WebServlet("/VehicleAddServlet")

public class VehicleAddServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		/**
		 * 获取网页中的数据
		 * 员工编号，姓名，密码，年龄，性别，电话号码
		 */
		request.setCharacterEncoding("UTF-8");
		String vehiclenum = request.getParameter("vehiclenum");
		String vehiclelicence = request.getParameter("vehiclelicence");
		String vehiclemodel = request.getParameter("vehiclemodel");
		VehicleInfo vehicle = new VehicleInfo();
		
		vehicle.setVehiclenum(vehiclenum);
		vehicle.setVehiclelicence(vehiclelicence);
		vehicle.setVehiclemodel(vehiclemodel);
		vehicle.setClientnum(vehiclenum);
		vehicle.setDictionaryid("1");
		
		
		VehicleSerives vehicleService = new VehicleSerives();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		boolean Verifyaddvehicle = vehicleService.AddVehicle(vehicle);
		Map<String,String> map = new HashMap<String, String>();
		
		/*
		 * 记录用户的操作记录
		 */
		HttpSession session = request.getSession();
		AFUserInfo userInfo = (AFUserInfo) session.getAttribute("CURRENTLOGINUSER");
		
		RecordAssist recordAssist = new RecordAssist("添加车辆"+vehicle.getVehiclenum(), userInfo);
		
		if(Verifyaddvehicle)
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
