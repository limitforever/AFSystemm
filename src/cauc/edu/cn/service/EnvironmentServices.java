package cauc.edu.cn.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import cauc.edu.cn.model.EnvironmentInfo;
import cauc.edu.cn.model.PaginationInfo;

public class EnvironmentServices extends BaseServices{

	/**
	 * 注册，连接并保存到数据库
	 * @param oilworker
	 * @throws ParseException 
	 */
	
	public boolean AddEnvironment(EnvironmentInfo environment) throws ParseException
	{
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
       
		String sql = "INSERT INTO environment(temperature, fueldensity, messuredtime) VALUES (?, ?, ?)";
//		System.out.print("come in");
		
		Date convertResult = (Date) (sdf2.parse(environment.getMessuredtime()));
		
		
		Object[] objects = new Object[]
		{		
				environment.getTemperature(),
				environment.getFueldensity(),
				convertResult
		};
			
		if ((DBHelper.executeNonQuery(sql, objects) >= 1)) 
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}//end AddUser()
	


	/**
	 * 支持分页的全部查询
	 * @return
	 * @throws ParseException 
	 */
	public PaginationInfo queryEnvironmentByPagination(int currentPageNum,int pageSize,Map<String, String> queryCondition) throws ParseException
	{
		String sql = "SELECT * FROM environment";
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
			
		for (String fieldName : queryCondition.keySet())
		{
			System.out.print("come in");
			if ((fieldName.equals("messuredtime_1")||fieldName.equals("messuredtime_2"))&&(!(queryCondition.get(fieldName)).equals("")))
			{						
				System.out.print("come in");
				String newfieldValue = sdf1.format(sdf2.parse(queryCondition.get(fieldName)));				
				queryCondition.put(fieldName, newfieldValue);					
			}
		}
		sql = buildQuerySql(sql, queryCondition);
		
		System.out.print(sql);
		
		return QueryBaseInfoByPagination(sql, currentPageNum, pageSize, EnvironmentInfo.class);
	}
}
