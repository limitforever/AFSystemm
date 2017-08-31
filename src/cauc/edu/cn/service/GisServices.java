package cauc.edu.cn.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cauc.edu.cn.model.GisInfo;

public class GisServices extends BaseServices
{
	public boolean AddGisInfo(GisInfo gisInfo) throws ParseException
	{
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		String sql = "INSERT INTO gis(xposition,yposition,vehiclenum,workeruserid,speed,logtime)value(?,?,?,?,?,?)";
		Date convertResult = (Date) (sdf2.parse(gisInfo.getLogtime()));
		
		Object[] objects = new Object[]
		{		
				gisInfo.getXposition(),
				gisInfo.getYposition(),
				gisInfo.getVehiclenum(),
				gisInfo.getWorkeruserid(),
				gisInfo.getSpeed(),
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
