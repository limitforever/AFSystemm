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

public class OilTotalAirline extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
        response.setCharacterEncoding("UTF-8");
        JSONArray maplists2 = new JSONArray();
        OilTotalAirlineService oilTotalAirlineService= new OilTotalAirlineService();
        maplists2 = oilTotalAirlineService.GetStatisticOilWorkerData();
        Gson gson2 = new Gson();  		  
		String message2 = gson2.toJson(maplists2);//把对象转为JSON格式的字符串  
		System.out.println("把对象转为JSON格式的字符串///  "+message2); 
        System.out.println(message2);
 //json.put("series", array);
    //System.out.println(json.toString());
    PrintWriter pw = response.getWriter();
    //pw.print(json.toString());
    pw.print(message2);
    pw.close();
  }

}