package cauc.edu.cn.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;



import com.mysql.jdbc.Connection;

import cauc.edu.cn.model.ClientInfo;
import cauc.edu.cn.model.FuelSheetInfo;
import cauc.edu.cn.model.PaginationInfo;

public class FuelSheetSerivces extends BaseServices
{
	/**
	 * 支持分页的全部查询
	 * @return 加油单查看
	 * @throws NoSuchFieldException 
	 */
	public PaginationInfo queryFuelSheetByPagination(int currentPageNum,int pageSize,Map<String, String> queryCondition) throws NoSuchFieldException
	{
		String sql = "select fuel.fuelsheetid, fuel.fuelsheetnum, flight.flno as oilbrand,flight.alcd as arrivespecificlocationtime,fuel.startfueltime as waitimageurl ,fuel.overfueltime as startfueltime,fuel.arrivespecificlocationtime as earliestfueltime ,  vehicle.vehiclelicence as latestfueltime,  fuel.oiltotal as fuelduration, oilworker.workerusername as overfueltime,fuel.waitimageurl as vehiclenum ,fuel.imageurlover as workeruserid from fuelsheet fuel inner join flightinformation flight on fuel.flid = flight.flid INNER JOIN oilworker on oilworker.workeruserid = fuel.workeruserid INNER JOIN vehicle on vehicle.vehiclenum = fuel.vehiclenum where fuel.dictionaryid = '5'";
		return QueryBaseInfoByPagination(sql, currentPageNum, pageSize, FuelSheetInfo.class);
	}
	
	/**
	 * 获取派工单数据发送至Android端（加油单）
	 * @param fuelSheetInfo
	 * @return FuelSheetInfo
	 */
	public FuelSheetInfo queryAndroidFuelSheetByPagination(FuelSheetInfo fuelSheetInfo) 
	{
		
		ResultSet resultSet =  null;
		Connection conn = (Connection) DBHelper.getConnection();
		
		try {
			String sql = "select fuel.fuelsheetnum, flight.flno as waitimageurl ,flight.stnd as imageurlover, fuel.workeruserid,fuel.vehiclenum, fuel.earliestfueltime,fuel.latestfueltime FROM fuelsheet fuel INNER JOIN flightinformation flight on fuel.flid = flight.flid where fuel.fuelsheetid = ?";
			
			Object[] object = new Object[]{
					fuelSheetInfo.getFuelsheetid()
			};
			
			 resultSet = DBHelper.executeQuery(sql,conn,object);
			
			if (resultSet.next()) 
			{
				fuelSheetInfo.setFuelsheetnum(resultSet.getString("fuelsheetnum"));
				fuelSheetInfo.setWaitimageurl(resultSet.getString("waitimageurl"));
				fuelSheetInfo.setImageurlover(resultSet.getString("imageurlover"));
				fuelSheetInfo.setWorkeruserid(resultSet.getString("workeruserid"));
				fuelSheetInfo.setVehiclenum(resultSet.getString("vehiclenum"));
				fuelSheetInfo.setEarliestfueltime(resultSet.getString("earliestfueltime"));
				fuelSheetInfo.setLatestfueltime(resultSet.getString("latestfueltime"));	
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBHelper.free(conn);
			DBHelper.free(resultSet);
		}
		
		return fuelSheetInfo;
	}


	/**
	 * 通过派工单中车辆ID，将对应的ClientID获取由于推送消息
	 * @param fuelSheetInfo
	 * @return
	 */
	public ClientInfo queryAndroidClientByPagination(FuelSheetInfo fuelSheetInfo) 
	{
		
		ResultSet resultSet =  null;
		Connection conn = (Connection) DBHelper.getConnection();
		ClientInfo clientInfo = new ClientInfo();
		
		try {
			String sql = "SELECT v.vehiclenum,c.appid,c.appkey,c.master,c.clientcid  from client c INNER JOIN vehicle v on c.clientnum = v.clientnum INNER JOIN fuelsheet fuel on fuel.vehiclenum = v.vehiclenum where fuelsheetid = ?";
			
			Object[] object = new Object[]{
					fuelSheetInfo.getFuelsheetid()
			};
			
			 resultSet = DBHelper.executeQuery(sql,conn,object);
			
			if (resultSet.next()) 
			{
				clientInfo.setAppid(resultSet.getString("appid"));
				clientInfo.setAppkey(resultSet.getString("appkey"));
				clientInfo.setMaster(resultSet.getString("master"));
				clientInfo.setClientcid(resultSet.getString("clientcid"));
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBHelper.free(conn);
			DBHelper.free(resultSet);
		}
		
		return clientInfo;
	}
}
