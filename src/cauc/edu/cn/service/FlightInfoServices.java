package cauc.edu.cn.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import cauc.edu.cn.model.FlightInfo;
import cauc.edu.cn.model.PaginationInfo;

/**
 * 
 * @author Administrator
 * 响应航班数据服务类
 */

public class FlightInfoServices extends BaseServices{
	
	//增加航班数据
	public static boolean AddFlight(FlightInfo flightInfo){
		
		String sql = "INSERT INTO flightinformation(flid, flno, reno, alcd, stnd, scdt, scat, mvin) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		Object[] objects = new Object[] {
				flightInfo.getFlid(),
				flightInfo.getFlno(),
				flightInfo.getReno(),
				flightInfo.getAlcd(),
				flightInfo.getStnd(),
				flightInfo.getScdt(),
				flightInfo.getScat(),
				flightInfo.getMvin()
		};
		
		for (Object object : objects) {
			System.out.println(object);
			
		}
		//return false;
		return (DBHelper.executeNonQuery(sql, objects) == 1);
	}//AddFlight()
	
	/**
	 * 用户查询获取分页信息实体
	 * @param currentPageNum
	 * @param pageSize
	 * @param queryConditionMap
	 * @return PaginationInfo 分页信息实体
	 * @throws ParseException 
	 */
	public PaginationInfo queryFlightByPagination(int currentPageNum, int pageSize, Map<String, String> queryConditionMap) throws ParseException
	{
		
		String sql = "SELECT * FROM flightinformation";
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		 
		for (String fieldName : queryConditionMap.keySet())
		{
			if ((fieldName.equals("scat_1")||fieldName.equals("scat_2")||fieldName.equals("scdt_1")||fieldName.equals("scdt_2"))&&(!(queryConditionMap.get(fieldName)).equals("")))
			{						
				String newfieldValue = sdf1.format(sdf2.parse(queryConditionMap.get(fieldName)));				
				queryConditionMap.put(fieldName, newfieldValue);					
			}
		}
	    String buildQuerySql = buildQuerySql(sql, queryConditionMap);
		
		
		return QueryBaseInfoByPagination(buildQuerySql, currentPageNum, pageSize, FlightInfo.class);
		
	}//queryFlightByPagination()
	
	/**
	 * 获取更新航班数据
	 * @param flightInfo
	 * @return bool 是否添加成功
	 */
	public static boolean UpdateFlightInfo(FlightInfo flightInfo){
		String sql = "UPDATE flightinformation(fint) VALUES(?)";
		
		Object[] objects = new Object[]{
				flightInfo.getFint()
		};
		
		return (DBHelper.executeNonQuery(sql, objects) == 1);
	}//UpdateFlightInfo()
	
	
	/**
	 * 查询状态为已更新的航班
	 */
	public PaginationInfo queryFlightDictionaryByPagination(int currentPageNum, int pageSize, Map<String, String> queryConditionMap) throws ParseException{
		
		String sql = "SELECT f.flid,f.flno,dictionary.dictionaryname as reno FROM flightinformation f INNER JOIN dictionary on f.dictionaryid = dictionary.dictionaryid WHERE f.dictionaryid = '7'";		
		return QueryBaseInfoByPagination(sql, currentPageNum, pageSize, FlightInfo.class);
		
	}//queryFlightByPagination()
	
}//class
