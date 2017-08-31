package cauc.edu.cn.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;




import net.sf.json.JSONArray;
import net.sf.json.JSONObject;





import com.google.gson.Gson;
import com.google.gson.JsonArray;

import cauc.edu.cn.model.OilAirlineFuelInfo;
import cauc.edu.cn.model.OilWorkFuelInfo;
import cauc.edu.cn.model.OilbrandAirlineInfo;

/**
 * 获取油量品牌数据
 * 
 * @author Administrator
 *
 */
public class OilBrandAirlineService {

	public Map<String, ArrayList<OilbrandAirlineInfo>> GetStatisticOilbrandAirlineInfo() {


		Map<String, ArrayList<OilbrandAirlineInfo>> mapLists = new HashMap<String, ArrayList<OilbrandAirlineInfo>>();

		Map<String, String[]> monthMap = InitMonthMap();

		java.sql.Connection conn = DBHelper.getConnection();

		String sql = "SELECT alcd, fuelsheet.flid, SUM(month) AS OilBrandCount FROM FuelSheet  INNER JOIN flightinformation ON fuelsheet.flid = flightinformation.flid WHERE overfueltime >= ? AND overfueltime < ? group by fuelsheet.flid";

		Set<String> sets = monthMap.keySet();

 
		
		try {

			for (String string : sets) {
				
				

				Date date = new Date();
				SimpleDateFormat sdfDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				@SuppressWarnings("deprecation")
				int year = date.getYear();
				
				String[] strings = monthMap.get(string)[0].split("-");
				String[] Strings =  monthMap.get(string)[1].split("-");
				String earlyDate =sdfDateFormat.format(new Date(year, Integer.valueOf(strings[0]), Integer.valueOf(strings[1])));
				String lastDate = sdfDateFormat.format(new Date(year, Integer.valueOf(Strings[0]), Integer.valueOf(Strings[1])));
				Object[] objects = { earlyDate,lastDate
						 };
				System.out.println(string + "对应的SQL语句： " + sql + earlyDate + lastDate);
				
				mapLists.put(string,GetStatisticOilbrandAirline(sql, conn, objects));

				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return mapLists;
	}// GetStatisticOilWorkerInfo()

	public Map<String, String[]> InitMonthMap() {
		Map<String, String[]> monthMap = new HashMap<String, String[]>();

		String[] monthString_1 = { "00-01", "01-01" };
		monthMap.put("1月", monthString_1);
		String[] monthString_2 = { "01-01", "02-01" };
		monthMap.put("2月", monthString_2);
		String[] monthString_3 = { "02-01", "03-01" };
		monthMap.put("3月", monthString_3);
		String[] monthString_4 = { "03-01", "04-01" };
		monthMap.put("4月", monthString_4);
		String[] monthString_5 = { "04-01", "05-01" };
		monthMap.put("5月", monthString_5);
		String[] monthString_6 = { "05-01", "06-01" };
		monthMap.put("6月", monthString_6);
		String[] monthString_7 = { "06-01", "07-01" };
		monthMap.put("7月", monthString_7);
		String[] monthString_8 = { "07-01", "08-01" };
		monthMap.put("8月", monthString_8);
		String[] monthString_9 = { "08-01", "09-01" };
		monthMap.put("9月", monthString_9);
		String[] monthString_10 = { "09-01", "10-01" };
		monthMap.put("10月", monthString_10);
		String[] monthString_11 = { "10-01", "11-01" };
		monthMap.put("11月", monthString_11);
		String[] monthString_12 = { "11-01", "11-31" };
		monthMap.put("12月", monthString_12);
		return monthMap;
	}

	public ArrayList<OilbrandAirlineInfo> GetStatisticOilbrandAirline(String sql, java.sql.Connection conn,
			Object[] obj) throws SQLException {

		ArrayList<OilbrandAirlineInfo> oilbrandAirlineInfos = new ArrayList<OilbrandAirlineInfo>();


//		System.out.println(obj[0].toString()+ obj[1].toString());
		ResultSet resultSet = DBHelper.executeQuery(sql, conn, obj);

		while (resultSet.next()) {
			OilbrandAirlineInfo oilbrandAirlineInfo = new OilbrandAirlineInfo();

			oilbrandAirlineInfo.setAlcd(resultSet.getString("alcd"));
			oilbrandAirlineInfo.setOilBrand(resultSet.getDouble("OilBrandCount"));
			oilbrandAirlineInfos.add(oilbrandAirlineInfo);
			
		//	System.out.println(obj[0]+" 员工姓名: "+oilAirlineFuelInfo.getOilWorkername()+" 油量: "+oilWorkFuelInfo.getOilTotal());
		}

		/* Gson gson = new Gson();  		  
			String message2 = gson.toJson(oilWorkFuelInfos);//把对象转为JSON格式的字符串  
			System.out.println("把对象转为JSON格式的字符串(修改)  "+message2); */
		return oilbrandAirlineInfos;

	}// function

	public JSONArray GetStatisticOilBrandData(){
				
		Map<String, ArrayList<Double>> maplists = new HashMap<String, ArrayList<Double>>();

		
		int j = 0;
	
		Object[] objects = new Object[2];
		ArrayList<Object[]> objectList = new ArrayList<Object[]>();
		
		for (Entry<String, ArrayList<OilbrandAirlineInfo>> strings : GetStatisticOilbrandAirlineInfo().entrySet()) {
			
			

			
			for (OilbrandAirlineInfo info : strings.getValue()) {
//				 Gson gson = new Gson();  		  
//					String message = gson.toJson(info);//把对象转为JSON格式的字符串  
//					System.out.println(strings.getKey() +  "对应的员工数据  "+ message);
			//		System.out.println(" 员工: "+info.getOilWorkername()+ " 油量: " + info.getOilTotal());
				
//				System.out.println("info" + info.getOilWorkername());
				ArrayList<Double> lists = new ArrayList<Double>();		
				if (j == 0) {					
					lists.add(info.getOilBrand());
					maplists.put(info.getAlcd(), lists);
				}else{
					maplists.get(info.getAlcd()).add(info.getOilBrand());
				}
			}
			j  = 1;
			
		}//for		
		
		JSONObject member = new JSONObject();
		JSONArray array = new JSONArray();
		
		for (Entry<String, ArrayList<Double>> mapes : maplists.entrySet()) {

			
			member.put("name", mapes.getKey());
			member.put("data", mapes.getValue());
			
			array.add(member);
			
		}
		JsonArray dataArray = new JsonArray();
		return array;
		

		
	} //GetStatisticOilWorkerData()
	
}// class
