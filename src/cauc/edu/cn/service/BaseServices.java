package cauc.edu.cn.service;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import com.mysql.jdbc.Connection;

import cauc.edu.cn.model.BaseInfo;
import cauc.edu.cn.model.PaginationInfo;


public class BaseServices 
{

	/**
	 * 
	 * @return
	 */
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public String buildQuerySql(String sql,Map<String, String> queryConditionMap)
	{
		if(queryConditionMap!=null&&queryConditionMap.size()>0)
		{
			sql+= " WHERE ";
			boolean flag = false;
			
			for (String fieldName : queryConditionMap.keySet())
			{
				String fieldValue = queryConditionMap.get(fieldName);
			
				if(!fieldName.equals("currentPageNum")&&!fieldValue.equals(""))
				{
					flag =true;
					if(fieldName.split("_").length>1)
					{
						String[] split = fieldName.split("_");
						if(split[1].endsWith("1")){
							sql+=split[0]+">='"+fieldValue+"' AND ";
						}
						if(split[1].endsWith("2")){
							sql+=split[0]+"<='"+fieldValue+"' AND ";
						}
						if(split[1].endsWith("l")){
							sql+=split[0]+" LIKE '%"+fieldValue+"%' AND ";
						}
					}
					else{
						//代码的健壮性
							sql+=fieldName+"='"+fieldValue+"' AND ";					
					}					
				}
			}
			if(flag)
			{
				
				return sql=sql.substring(0, sql.length()-4);
				
			}
			else
			{
				return sql.substring(0, sql.length()-6);
			}
		}

		return sql;
	}

	public PaginationInfo QueryBaseInfoByPagination(String sql, int currentPageNum, int pageSize, Class<?> className)
	{
		//定义分页辅助实体对象
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
				/**
				 * JDBC 数据元
				 * 将本次查询的数据元信息获取
				 * 元数据，描述数据
				 */
				ResultSetMetaData metaData = resultSet.getMetaData();
				/**
				 * 反射
				 */
				//根据外部参数传入的实体名称，创建该实体的实例对象（强制类型转成接口）
				BaseInfo newInstance = (BaseInfo) className.newInstance();
				//根据该类，获取该类下所有的属性(field，要求名称与数据库字段完全一致（包含大小写）)
				//循环，循环的次数为（该次查询的字段个数，或者是属性的个数）
				for(int i=0;i<metaData.getColumnCount();i++){
					//根据列的索引（从1开始），获取字段名称
					String columnName = metaData.getColumnLabel(i+1).toLowerCase();
					//根据字段的名称，获取字段的值
					Object columnValue = resultSet.getObject(columnName);
					String fieldName = className.getDeclaredField(columnName).getName();
					
//					System.out.println(columnName);
//					System.out.println(fieldName);
					
					
					//20150710在执行方法时应该判断表中的数据
					if(columnValue!=null)
					{
						//根据类下的属性，获取其中一个属性的名称
						//为调用setXX某某属性的方法，我们需要将属性的首字母转换成大写
						fieldName=fieldName.toLowerCase().substring(0, 1).toUpperCase()+fieldName.substring(1, fieldName.length());
						//用set+转换成首字母大写的属性名，调用该属性的set方法，将参数类型放入
						Method declaredMethod = className.getDeclaredMethod("set"+fieldName,className.getDeclaredField(columnName).getType());
						//执行set方法，将数据库中字段的值传入该set方法的参数
						
						if(columnValue.getClass()==java.sql.Timestamp.class)
						{
							columnValue = simpleDateFormat.format(columnValue);
						}
						
						declaredMethod.invoke(newInstance, columnValue);
					}
				}
				//将创建的对象，加入到结果集
				baseInfoList.add(newInstance);
			}
			
			PaginationInfo.setBaseInfoList(baseInfoList);
			PaginationInfo.setTotalCountNum(totalCountNum);
			PaginationInfo.setTotalPageNum(totalPageNum);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
			try {				
				resultSet.close();
				resultSetCount.close();
				DBHelper.free(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return PaginationInfo;
		
	}//end QueryBaseInfoByPagination()
	
}//end class
