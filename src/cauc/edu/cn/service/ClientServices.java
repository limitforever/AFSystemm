package cauc.edu.cn.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.mysql.jdbc.Connection;

import cauc.edu.cn.model.PaginationInfo;
import cauc.edu.cn.model.ClientInfo;

public class ClientServices extends BaseServices
{	
	/**
	 * 注册，连接并保存到数据库
	 * @param 
	 */
	
	public boolean AddClient(ClientInfo Machine)
	{
		String sql = "INSERT INTO client(clientid, clientcid,clientnum) VALUES (?, ?, ?)";
		
		Object[] objects = new Object[]
		{		
				Machine.getClientid(),
				Machine.getClientcid(),
				Machine.getClientnum(),
					
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
	 *  删除一个客户端
	 * @param afuser
	 * @return
	 */
	public boolean DelClient(ClientInfo Machine)	
	{
		
		String sql = "DELETE FROM client Where clientid = ?";
		
		Object[] objects = new Object[] 
		{	
				Machine.getClientid()
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
	
	public boolean UpdateClient(ClientInfo Machine){
		
		String sql = "UPDATE client SET  clientcid = ?, clientnum = ? where clientid = ?";
		
		Object[] objects = new Object[] 				
		{						
				Machine.getClientcid(),
				Machine.getClientnum(),
				Machine.getClientid(),
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
	 * 根据编号查询一个客户端
	 * @param id
	 * @return
	 */
	
	public static ArrayList<ClientInfo> GetAllClient() 
	{
		
		ArrayList<ClientInfo> MachineInfoList = new ArrayList<ClientInfo>();
		ResultSet resultSet = null;
		Connection conn = (Connection) DBHelper.getConnection();
		
		try {
			String sql = "SELECT * FROM client WHERE clientid = ?";
			
			resultSet = DBHelper.executeQuery(sql,conn);
			
			while(resultSet.next())
			{
				ClientInfo Machine = new ClientInfo();
					
				Machine.setClientid(resultSet.getInt("clientid"));
		        Machine.setClientcid(resultSet.getString("clientcid"));
		        Machine.setClientnum(resultSet.getString("clientnum"));

		       
			
		        MachineInfoList.add(Machine);
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
		return MachineInfoList;
	}//end GetAllUser()


	/**
	 * 支持分页的全部查询
	 * @return
	 * @throws NoSuchFieldException 
	 */
	public PaginationInfo queryClientByPagination(int currentPageNum,int pageSize,Map<String, String> queryCondition) throws NoSuchFieldException
	{
		String sql = "SELECT * FROM client";
		sql = buildQuerySql(sql, queryCondition);
		return QueryBaseInfoByPagination(sql, currentPageNum, pageSize, ClientInfo.class);
	}
}
//
