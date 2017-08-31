package cauc.edu.cn.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.mysql.jdbc.Connection;

import cauc.edu.cn.model.PaginationInfo;
import cauc.edu.cn.model.VehicleInfo;

public class VehicleSerives extends BaseServices
{	
	/**
	 * 注册，连接并保存到数据库
	 * @param 
	 */
	
	public boolean AddVehicle(VehicleInfo vehicle)
	{
		String sql = "INSERT INTO vehicle(vehiclenum, vehiclelicence, vehiclemodel, clientnum, dictionaryid) VALUES (?, ?, ?, ?, ?)";
		
		Object[] objects = new Object[]
		{		
				vehicle.getVehiclenum(),
				vehicle.getVehiclelicence(),
				vehicle.getVehiclemodel(),
				vehicle.getClientnum(),
				vehicle.getDictionaryid()
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
	 *  删除一个车辆
	 * @param afuser
	 * @return
	 */
	public boolean DelVehicle(VehicleInfo vehicle)	
	{
		
		String sql = "DELETE FROM vehicle Where vehicleid = ?";
		
		Object[] objects = new Object[] 
		{	
				vehicle.getVehicleid()
		};		

		if((DBHelper.executeNonQuery(sql, objects)) >= 1)
		{
			return true;
		}else {
			return false;
		}
	}//end DelUser()
	
	
	/**
	 * 更新某个车辆
	 * @param user
	 * @return
	 */
	
	public boolean UpdateVehicle(VehicleInfo vehicle){
		
		String sql = "UPDATE vehicle SET vehiclenum = ?, vehiclelicence = ?, vehiclemodel = ? where vehicleid = ?";
		
		Object[] objects = new Object[] 				
		{		
				vehicle.getVehiclenum(),
				vehicle.getVehiclelicence(),
				vehicle.getVehiclemodel(),
				vehicle.getVehicleid()
		};
		
		if((DBHelper.executeNonQuery(sql, objects)) >= 1)
		{
			return true;
		}
		else
        {
			return false;
		}
		
	}//end UpdateUser()

	
	/**
	 * 根据编号查询一个车辆
	 * @param id
	 * @return
	 */
	
	public static ArrayList<VehicleInfo> GetAllUser() 
	{
		
		ArrayList<VehicleInfo> vehicleInfoList = new ArrayList<VehicleInfo>();
		ResultSet resultSet = null;
		Connection conn = (Connection) DBHelper.getConnection();
		
		try {
			String sql = "SELECT * FROM vehicle WHERE vehicleid = ?";
			
			resultSet = DBHelper.executeQuery(sql,conn);
			
			while(resultSet.next())
			{
				VehicleInfo vehicle = new VehicleInfo();
					
				vehicle.setVehicleid(resultSet.getInt("vehicleid"));
		        vehicle.setVehiclenum(resultSet.getString("vehiclenum"));
		        vehicle.setVehiclelicence(resultSet.getString("vehiclelicence"));
		        vehicle.setVehiclemodel(resultSet.getString("vehiclemodel"));
		        vehicle.setClientnum(resultSet.getString("clientnum"));
			
		        vehicleInfoList.add(vehicle);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}finally 
		{
			DBHelper.free(resultSet);
			DBHelper.free(conn);
		}
		return vehicleInfoList;
	}//end GetAllUser()


	/**
	 * 支持分页的全部查询
	 * @return
	 * @throws NoSuchFieldException 
	 */
	public PaginationInfo queryVehicleByPagination(int currentPageNum,int pageSize,Map<String, String> queryCondition) throws NoSuchFieldException
	{
		String sql = "select v.vehicleid,v.vehiclenum,v.vehiclelicence,v.vehiclemodel,v.clientnum,dictionary.dictionaryname as dictionaryid from vehicle v inner join dictionary on v.dictionaryid = dictionary.dictionaryid";
		sql = buildQuerySql(sql, queryCondition);
		return QueryBaseInfoByPagination(sql, currentPageNum, pageSize, VehicleInfo.class);
	}
	
}
//
