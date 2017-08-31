package cauc.edu.cn.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import com.mysql.jdbc.Connection;

import cauc.edu.cn.common.RecordAssist;
import cauc.edu.cn.model.BaseInfo;
import cauc.edu.cn.model.OperatorRecordJSPInfo;
import cauc.edu.cn.model.PaginationInfo;

/**
 * 
 * @author Administrator
 * 添加管理员操作的数据信息
 */
public class OperatorRecordServices extends BaseServices{
	/**
	 * 添加管理员操作记录表
	 * @param userInfo
	 * @param date
	 * @param descr
	 * @return boolean 是否添加成功
	 */
	public static boolean AddOperatorRecord(RecordAssist recordAssist) {
		String sql = "INSERT INTO OperatorRecord(userid, operatortime, operatordescr) VALUES(?,?,?)";
		
		Object[] objects = new Object[]{	
				recordAssist.getUserInfo().getUsernum(), recordAssist.getDate(), recordAssist.getDescr()
		};
		
		return (DBHelper.executeNonQuery(sql, objects) == 1);
		
	}//AddOperatorRecord()
	
	/**
	 * 支持分页的全部查询
	 * @return
	 * @throws NoSuchFieldException 
	 */
	public PaginationInfo queryOperatoRrecordByPagination(int currentPageNum,int pageSize,Map<String, String> queryCondition) throws NoSuchFieldException
	{	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = "SELECT afuser.username,o.usernum,o.operatortime,o.operatordescr  FROM operatorrecord o INNER JOIN afuser on afuser.usernum = o.usernum";
		
		if(queryCondition!=null&&queryCondition.size()>0)
		{
			sql+= " WHERE ";
			boolean flag = false;
			
			for (String fieldName : queryCondition.keySet())
			{
				String fieldValue = queryCondition.get(fieldName);
			
				if(!fieldName.equals("currentPageNum")&&!fieldValue.equals(""))
				{
					System.out.println(fieldName);
					System.out.println(fieldValue);
					flag =true;
					if(fieldName.equals("usernum"))
					{
						System.out.println("come inb");
						sql=sql+"o.usernum="+fieldValue+"%AND";
					}
					
					else
					{
						//代码的健壮性
							sql+=fieldName+"='"+fieldValue+"' AND ";					
					}					
				}
			}
			if(flag)
			{
				
				sql=sql.substring(0, sql.length()-4);
				
			}
			else
			{
				sql.substring(0, sql.length()-6);
			}
		}
		
		System.out.println(sql);
		
		PaginationInfo PaginationInfo = new PaginationInfo();
		
		ArrayList<BaseInfo> baseInfoList = new ArrayList<BaseInfo>();
		
		//对应显示页面的页号上显示的第一个数据行数
		int startIndex = (currentPageNum - 1) * pageSize;
		
		//选择对应每一页显示的数据信息
		String querytSql = sql + " LIMIT ?, ? ";
		//获取数据中所有数据总数量
		String countSql = "SELECT COUNT(*) FROM ("+ sql +") T";
		
		Object[] object = new Object[]
		{
				startIndex, pageSize
		};
		
		//保存表结构数据信息
		ResultSet resultSet = null;
		ResultSet resultSetCount = null;
		
		//获取表中含有的所有数据总和
		int totalCountNum = 0;
		//获取所有数据可以分为的页面
		int totalPageNum = 0;
		Connection conn = (Connection) DBHelper.getConnection();
		try {
			
			
			//获取所有的表中的数据
			resultSet = DBHelper.executeQuery(querytSql,conn,object);
			resultSetCount = DBHelper.executeQuery(countSql,conn);
			
			while (resultSetCount.next()) 
			{
				totalCountNum = resultSetCount.getInt(1);
			}
			
			//若页面刚好是可以分为整数页则为 totalCountNum / PageSize
			if (totalCountNum % pageSize == 0) 
			{
				totalPageNum = totalCountNum / pageSize;
			}
			else
			{
				totalPageNum = totalCountNum / pageSize + 1;
			}
			
			while(resultSet.next())
			{
				OperatorRecordJSPInfo operatorRecordJSPInfo = new OperatorRecordJSPInfo();
				if ((resultSet.getObject("usernum"))!=null)
				{		
					operatorRecordJSPInfo.setUsernum(resultSet.getInt("usernum"));
				}
				
				if(resultSet.getString("username")!=null)
				{			
					operatorRecordJSPInfo.setUsername(resultSet.getString("username"));
					
				}
				if(resultSet.getString("operatordescr")!=null)
				{			
					operatorRecordJSPInfo.setOperatordescr(resultSet.getString("operatordescr"));
				}
				if(resultSet.getObject("operatortime")!=null)
				{
					operatorRecordJSPInfo.setOperatortime(simpleDateFormat.format(resultSet.getObject("operatortime")));			
					baseInfoList.add((BaseInfo) operatorRecordJSPInfo);
				}
			}
			
			PaginationInfo.setBaseInfoList(baseInfoList);
			PaginationInfo.setTotalCountNum(totalCountNum);
			PaginationInfo.setTotalPageNum(totalPageNum);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{			
			try {	
				if(resultSet!=null)
				{			
					resultSet.close();
				}
				resultSetCount.close();
				DBHelper.free(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return PaginationInfo;
		
	}//end QueryBaseInfoByPagination()
}//class
