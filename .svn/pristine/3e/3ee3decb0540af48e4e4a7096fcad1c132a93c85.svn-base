package cauc.edu.cn.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cauc.edu.cn.model.ClientInfo;
import cauc.edu.cn.model.FuelSheetInfo;
import cauc.edu.cn.service.FuelSheetSerivces;

import com.google.gson.Gson;

import os_sdk_java.pushtoSingle;

@WebServlet("/PushMessageServlet")
public class PushMessageServlet extends HttpServlet
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
		Integer fuelsheetid = Integer.parseInt(request.getParameter("id"));
		FuelSheetInfo fuelSheetInfo = new FuelSheetInfo();
		fuelSheetInfo.setFuelsheetid(fuelsheetid);
		
		FuelSheetSerivces fuelSheetSerivce = new FuelSheetSerivces();
		FuelSheetInfo fuelSheetInfo1 = fuelSheetSerivce.queryAndroidFuelSheetByPagination(fuelSheetInfo);
			
		Gson gson = new Gson();
		Map<String, String> map1 = new HashMap<String, String>();
	    map1.put("fuelsheetnum",fuelSheetInfo1.getFuelsheetnum());
	    map1.put("workeruserid",fuelSheetInfo1.getWorkeruserid());	
	    map1.put("flno", fuelSheetInfo1.getWaitimageurl());		
	    map1.put("stnd", fuelSheetInfo1.getImageurlover());		
	    map1.put("vehiclenum", fuelSheetInfo1.getVehiclenum());		
	    map1.put("estimatedarrivetime",fuelSheetInfo1.getEarliestfueltime());		
	    map1.put("latestfueltime", fuelSheetInfo1.getLatestfueltime());		
	    
	    String json = gson.toJson(map1);
	    
	    ClientInfo clientInfo = fuelSheetSerivce.queryAndroidClientByPagination(fuelSheetInfo);
	    
	    
	    String appId = clientInfo.getAppid();
	    String appkey = clientInfo.getAppkey();
	    String master = clientInfo.getMaster();
	    String CID = clientInfo.getClientcid();
	   
	      System.out.println(appId);
	      System.out.println(appkey);
	      System.out.println(master);
	      System.out.println(CID);

	    
		try {
			pushtoSingle.pushmessage(json,appId,appkey,master,CID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//是否改变URL的路径
		response.sendRedirect(request.getContextPath() + "/Index.jsp");
//		request.getRequestDispatcher("/Index.jsp").forward(request, response);
	}
}
