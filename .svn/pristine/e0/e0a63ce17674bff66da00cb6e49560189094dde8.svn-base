package cauc.edu.cn.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import cauc.edu.cn.model.PaginationInfo;
import cauc.edu.cn.model.VehicleLogInfo;

public class VehicleLogServices extends BaseServices{

	public PaginationInfo queryVehicleLogByPagination(int currentPageNum,int pageSize,Map<String, String> queryCondition) throws NoSuchFieldException
	{
		String sql = "SELECT o.workerusername as workeruserid,v.vehiclenum,v.speed,v.logtime FROM VehicleLog v INNER JOIN oilworker o on o.workeruserid = v.workeruserid";
		sql = buildQuerySql(sql, queryCondition);
		System.out.print(sql);
		return QueryBaseInfoByPagination(sql, currentPageNum, pageSize, VehicleLogInfo.class);
	}
	
	public boolean AddVehicleLogInfo(VehicleLogInfo vehiclelog) throws ParseException
	{
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		String sql = "INSERT INTO vehiclelog(xposition,yposition,vehiclenum,workeruserid,speed,logtime)value(?,?,?,?,?,?)";
		Date convertResult = (Date) (sdf2.parse(vehiclelog.getLogtime()));
		
		Object[] objects = new Object[]
		{		
				vehiclelog.getXposition(),
				vehiclelog.getYposition(),
				vehiclelog.getVehiclenum(),
				vehiclelog.getWorkeruserid(),
				vehiclelog.getSpeed(),
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
}
