package cauc.edu.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cauc.edu.cn.service.OilBrandAirlineService;
import cauc.edu.cn.service.OilTotalAirlineService;
import cauc.edu.cn.service.OilTotalStatisticService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class OilTotalStatistic extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.setCharacterEncoding("UTF-8");

    JSONArray maplists = new JSONArray();
        OilTotalStatisticService oilTotalStatisticService= new OilTotalStatisticService();
        maplists = oilTotalStatisticService.GetStatisticOilWorkerData();
        Gson gson = new Gson();  		  
		String message1 = gson.toJson(maplists);//把对象转为JSON格式的字符串  
		System.out.println("把对象转为JSON格式的字符串///  "+message1); 
        System.out.println(message1);
 //json.put("series", array);
    //System.out.println(json.toString());
    PrintWriter pw = response.getWriter();
    //pw.print(json.toString());
    pw.print(message1);
    pw.close();

  }

}