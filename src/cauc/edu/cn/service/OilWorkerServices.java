package cauc.edu.cn.service;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.mysql.jdbc.Connection;

import cauc.edu.cn.common.MD5Encrypted;
import cauc.edu.cn.model.LoginUserInfo;
import cauc.edu.cn.model.OilWorkerInfo;
import cauc.edu.cn.model.PaginationInfo;

public class OilWorkerServices extends BaseServices {
 
	/**
	 * 登陆验证加油员编号与密码是否正确
	 * @param oilworker
	 * @return
	 * @throws SQLException 
	 * @throws NoSuchAlgorithmException 
	 */
	public LoginUserInfo VerifyWorker(OilWorkerInfo oilworker, String nonenpassword) throws SQLException, NoSuchAlgorithmException
	{
		boolean  returnstatement = false;		
		ResultSet resultSet =  null;	
		LoginUserInfo loginUserInfo = new LoginUserInfo();
		Connection conn = (Connection) DBHelper.getConnection();
					
		String sql = "SELECT workeruserid, workerenpassword,workerusername FROM oilworker WHERE workeruserid= ?";
			
		
		Object[] object = new Object[]			
		{			
			oilworker.getWorkeruserid(),		
		};
			
		resultSet = DBHelper.executeQuery(sql,conn,object);
					
		if (resultSet.next()) 		
		{		
			byte[] enpassword = resultSet.getBytes("workerenpassword");
			oilworker.setWorkerusername(resultSet.getString("workerusername"));
			if((MD5Encrypted.VallidateWorkerPassword(nonenpassword, enpassword)))				
			{				
				returnstatement = true;		
			}			
			else		
			{		
				returnstatement = false;		
			}
		
		}			
		else 		
		{	
			returnstatement = false;					
		}
		
		DBHelper.free(resultSet);
		DBHelper.free(conn);
		loginUserInfo.setLogin(returnstatement);
		loginUserInfo.setOilWorkerInfo(oilworker);
		
		return loginUserInfo;
		
	}//VerifyUsers()

	
	
	/**
	 * 注册，连接并保存到数据库
	 * @param oilworker
	 */
	
	public boolean AddWorker(OilWorkerInfo oilworker)
	{
		String sql = "INSERT INTO oilworker(workeruserid, workerusername, workerenpassword, age, sex, phonenum) VALUES (?, ?, ?, ?, ?, ?)";
		
		Object[] objects = new Object[]
		{		
				oilworker.getWorkeruserid(),
				oilworker.getWorkerusername(),
				oilworker.getWorkerenpassword(),
				oilworker.getAge(),
				oilworker.getSex(),
				oilworker.getPhonenum(),								
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
	 *  删除一个用户
	 * @param afuser
	 * @return
	 */
	public boolean DelWorker(OilWorkerInfo oilworker)	
	{
		
		String sql = "DELETE FROM oilworker Where workerid = ?";
		
		Object[] objects = new Object[] 
		{
				oilworker.getWorkerid()
		};		

		if((DBHelper.executeNonQuery(sql, objects)) >= 1)
		{
			return true;
		}else {
			return false;
		}
	}//end DelUser()
	
	
	/**
	 * 更新某个用户
	 * @param user
	 * @return
	 */
	
	public boolean UpdateWorker(OilWorkerInfo oilworker){
		
		String sql = "UPDATE oilworker SET workeruserid = ?, workerusername = ?, age = ?, sex = ?, phonenum = ? where workerid = ?";
		
		Object[] objects = new Object[] 				
		{
			
				oilworker.getWorkeruserid(),
				oilworker.getWorkerusername(),
				oilworker.getAge(),
				oilworker.getSex(),
				oilworker.getPhonenum(),					
				oilworker.getWorkerid()
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
	 * 根据编号查询一个加油员工
	 * @param id
	 * @return
	 */
	
	public static ArrayList<OilWorkerInfo> GetAllWorker() 
	{
		
		ArrayList<OilWorkerInfo> workerInfoList = new ArrayList<OilWorkerInfo>();
		ResultSet resultSet = null;
		Connection conn = (Connection) DBHelper.getConnection();
		
		try {
			String sql = "SELECT * FROM OilWorkerInfo WHERE workeruserid = ?";
			
			resultSet = DBHelper.executeQuery(sql,conn);
			
			while(resultSet.next())
			{
				OilWorkerInfo oilworker = new OilWorkerInfo();
				
				oilworker.setWorkerid(resultSet.getInt("workerid"));
				oilworker.setWorkeruserid(resultSet.getString("workeruserid"));
				oilworker.setWorkerusername(resultSet.getString("workerusername"));
				oilworker.setAge(resultSet.getInt("age"));
				oilworker.setSex(resultSet.getString("sex"));
				oilworker.setPhonenum(resultSet.getString("phonenum"));
			
				workerInfoList.add(oilworker);
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
		return workerInfoList;
	}//end GetAllUser()


	/**
	 * 支持分页的全部查询
	 * @return
	 * @throws NoSuchFieldException 
	 */
	public PaginationInfo queryWorkerByPagination(int currentPageNum,int pageSize,Map<String, String> queryCondition) throws NoSuchFieldException
	{
		String sql = "SELECT * FROM OilWorker";
		sql = buildQuerySql(sql, queryCondition);
		return QueryBaseInfoByPagination(sql, currentPageNum, pageSize, OilWorkerInfo.class);
	}
	
	
	/**
	 * 获取所有加油人员
	 * @param currentPageNum
	 * @param pageSize
	 * @param queryCondition
	 * @return
	 * @throws NoSuchFieldException
	 */
	public PaginationInfo queryWorkerCountByPagination(int currentPageNum,int pageSize,Map<String, String> queryCondition) throws NoSuchFieldException
	{
		String sql = "SELECT workeruserid,workerusername FROM OilWorker";
		sql = buildQuerySql(sql, queryCondition);
		return QueryBaseInfoByPagination(sql, currentPageNum, pageSize, OilWorkerInfo.class);
	}		
	
}//end Class
