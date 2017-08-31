package cauc.edu.cn.service;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.mysql.jdbc.Connection;

import cauc.edu.cn.common.MD5Encrypted;
import cauc.edu.cn.model.PaginationInfo;
import cauc.edu.cn.model.AFUserInfo;
import cauc.edu.cn.model.LoginUserInfo;


public class UserServices extends BaseServices {
 
	/**
	 * 登陆验证员工编号与密码是否正确
	 * @param afuser *(usernum, enpassword)
	 * @return 
	 */
	public static LoginUserInfo VerifyUser(AFUserInfo afuser)
	{
		
		LoginUserInfo userInfo = new LoginUserInfo();
		boolean  returnstatement = false;
		
		ResultSet resultSet =  null;
		Connection conn = (Connection) DBHelper.getConnection();
		
		try {
			String sql = "SELECT * FROM afuser WHERE usernum = ?";
			
			Object[] object = new Object[]{
					afuser.getUsernum()
			};
			
			 resultSet = DBHelper.executeQuery(sql,conn,object);
			
			if (resultSet.next()) 
			{
				afuser.setUserid(resultSet.getInt("userid"));
				afuser.setUsernum(resultSet.getString("usernum"));
				afuser.setUsername(resultSet.getString("username"));
				afuser.setAge(resultSet.getInt("age"));
				afuser.setSex(resultSet.getString("sex"));
				afuser.setPhonenum(resultSet.getString("phonenum"));
				afuser.setEnpassword((MD5Encrypted.DoEncrypt("111111")));
				
				byte[] enpassword = resultSet.getBytes("enpassword");
							
				if((MD5Encrypted.VallidateUserPassword(afuser, enpassword)).isLogin())
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
		} 
		catch (NoSuchAlgorithmException | SQLException e)
		{
			e.printStackTrace();
		}
		
		DBHelper.free(resultSet);
		DBHelper.free(conn);
		
		userInfo.setLogin(returnstatement);
		userInfo.setUserInfo(afuser);
		
		return userInfo;
	}//VerifyUsers()
	
	
	/**
	 * 注册，连接并保存到数据库
	 * @param afuser *(usernum, username, enpassword, age, sex, phonenum) 
	 *  
	 */
	
	public boolean AddUser(AFUserInfo afuser)
	{
		String sql = "INSERT INTO afuser(usernum, username, enpassword, age, sex, phonenum) VALUES (?, ?, ?, ?, ?, ?)";
		
		Object[] objects = new Object[]
		{		
				afuser.getUsernum(),
				afuser.getUsername(),
				afuser.getEnpassword(),
				afuser.getAge(),
				afuser.getSex(),
				afuser.getPhonenum()			
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
	public boolean DelUser(AFUserInfo afuser)	
	{
		
		String sql = "DELETE FROM afuser Where userid = ?";
		
		Object[] objects = new Object[] {
				afuser.getUserid()
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
	 * @param user (usernum = ?, username = ?, age = ?, sex = ?, phonenum = ?)
	 */
	
	public boolean UpdateUser(AFUserInfo afuser){
		
		String sql = "UPDATE afuser SET usernum = ?, username = ?, age = ?, sex = ?, phonenum = ? where userid = ?";
		
		Object[] objects = new Object[] 				
		{
				afuser.getUsernum(),
				afuser.getUsername(),
				afuser.getAge(),
				afuser.getSex(),
				afuser.getPhonenum(),
				afuser.getUserid()
				
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
	 * 重置密码
	 * @param 
	 */
	public boolean UpdateUserpassword(AFUserInfo afuser){
		
		String sql = "UPDATE afuser SET enpassword = ? where userid = ?";
		
		Object[] objects = new Object[] 				
		{
				afuser.getEnpassword(),
				afuser.getUserid()
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
	 * 根据编号查询一个用户
	 * @param id
	 * @return
	 */
	
	public static ArrayList<AFUserInfo> GetAllUser() 
	{
		
		ArrayList<AFUserInfo> userInfoList = new ArrayList<AFUserInfo>();
		ResultSet resultSet = null;
		Connection conn = (Connection) DBHelper.getConnection();
		
		try {
			String sql = "SELECT * FROM AFUserInfo WHERE userid = ?";
			
			resultSet = DBHelper.executeQuery(sql,conn);
			
			while(resultSet.next())
			{
				AFUserInfo afuser = new AFUserInfo();
				
				afuser.setUserid(resultSet.getInt("userid"));
				afuser.setUsernum(resultSet.getString("usernum"));
				afuser.setUsername(resultSet.getString("username"));
				afuser.setAge(resultSet.getInt("age"));
				afuser.setSex(resultSet.getString("sex"));
				afuser.setNonenpassword(resultSet.getString("nonenpassword"));
				afuser.setPhonenum(resultSet.getString("phonenum"));
			
				userInfoList.add(afuser);
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
		return userInfoList;
	}//end GetAllUser()


	/**
	 * 支持分页的全部查询
	 * @return
	 * @throws NoSuchFieldException 
	 */
	public PaginationInfo queryUserByPagination(int currentPageNum,int pageSize,Map<String, String> queryCondition) throws NoSuchFieldException
	{
		String sql = "SELECT * FROM AFUSER";
		sql = buildQuerySql(sql, queryCondition);
		return QueryBaseInfoByPagination(sql, currentPageNum, pageSize, AFUserInfo.class);
	}
	
	/**
	 * 个人信息维护，通过usernum查询所有相关字段
	 * @param usernum
	 * @return
	 * @throws SQLException 
	 */
	public AFUserInfo getAFUserInfo(AFUserInfo afuser) throws SQLException
	{
		ResultSet resultSet = null;		  
		Connection conn = (Connection)DBHelper.getConnection();		
		String sql="select * from afuser where usernum=?";			
		Object[] object = new Object[]						
		{			
			afuser.getUsernum()
		};							
		resultSet = DBHelper.executeQuery(sql,conn,object);			
		
		while(resultSet.next())		
		{	  
			afuser.setUserid(resultSet.getInt("userid"));
			afuser.setUsernum(resultSet.getString("usernum"));
			afuser.setUsername(resultSet.getString("username"));
			afuser.setAge(resultSet.getInt("age"));
			afuser.setSex(resultSet.getString("sex"));
			afuser.setNonenpassword(resultSet.getString("enpassword"));				
			afuser.setPhonenum(resultSet.getString("phonenum"));	
		}
		
		DBHelper.free(resultSet);
		DBHelper.free(conn);
		
		return afuser;
	  }

	public boolean UpdateUserPSW(AFUserInfo afuser)
	{
		
		String sql = "UPDATE afuser SET  username = ?, enpassword = ?, age = ?, sex = ?, phonenum = ? where usernum = ?";
		
		Object[] objects = new Object[] 				
		{			
				afuser.getUsername(),
				afuser.getEnpassword(),
				afuser.getAge(),
				afuser.getSex(),
				afuser.getPhonenum(),				
				afuser.getUsernum(),	
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
	
}//end Class
