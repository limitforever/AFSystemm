package cauc.edu.cn.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cauc.edu.cn.common.PropertiesUtils;

/**
 * 
 * @author Administrator 
 * 用于执行DBHelper类的SQL语句
 * 
 */

public class DBHelper {

	// 此方法为获取数据库连接

	public static Connection getConnection()
	{

		String dbType = PropertiesUtils.getJdbcProperties("currentDBType");
		String dbDriver = "";
		String dbUrl = "";
		try {
			switch (dbType) 
			{
			case "mysql":
				dbDriver=PropertiesUtils.getJdbcProperties("mysqlDriver");
				dbUrl = "jdbc:mysql://"+PropertiesUtils.getJdbcProperties("mysqlHostIp")+":"+PropertiesUtils.getJdbcProperties("mysqlHostPort")+"/"+PropertiesUtils.getJdbcProperties("mysqlDbName")+"?useUnicode=true&characterEncoding=UTF-8";
				break;
				
			case "sqlserver":
				dbDriver=PropertiesUtils.getJdbcProperties("sqlserverDriver");
				dbUrl = "jdbc:sqlserver://"+PropertiesUtils.getJdbcProperties("sqlserverHostIp")+":"+PropertiesUtils.getJdbcProperties("sqlserverHostPort")+"/"+PropertiesUtils.getJdbcProperties("sqlserverDbName")+"?useUnicode=true&characterEncoding=UTF-8";
				break;
			case "oracle":
				dbDriver=PropertiesUtils.getJdbcProperties("oracleDriver");
				dbUrl = "jdbc:oracle:thin:@"+PropertiesUtils.getJdbcProperties("oracleHostIp")+":"+PropertiesUtils.getJdbcProperties("oracleHostPort")+"/"+PropertiesUtils.getJdbcProperties("oracleDbName")+"?useUnicode=true&characterEncoding=UTF-8";
				break;
			}
			Class.forName(dbDriver);
			return DriverManager.getConnection(dbUrl,PropertiesUtils.getJdbcProperties("mysqlDBUname"),PropertiesUtils.getJdbcProperties("mysqlDBUpwd"));
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * 增删改【Add、Delete、Update】
	 * @param sql
	 * @param obj
	 * @return int
	 * 
	 */
	public static int executeNonQuery(String sql, Object... obj) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(i + 1, obj[i]);
			}
			result = pstmt.executeUpdate();
		} catch (SQLException err) 
		{
			err.printStackTrace();
			free(null, pstmt, conn);
		}
		finally
		{
			free(null, pstmt, conn);
		}
		return result;
	}

	/**
	 * 
	 * 查【Query】
	 * 
	 * @param sql
	 * @param obj
	 * @return ResultSet
	 * 
	 */
	public static ResultSet executeQuery(String sql, Connection conn,Object... obj) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(i + 1, obj[i]);
			}
			rs = pstmt.executeQuery();
		} 
		catch (SQLException err) 
		{
			err.printStackTrace();			
			free(null, pstmt, conn);
		}
		return rs;
	}

	/**
	 * 
	 * 判断记录是否存在
	 * @param sql
	 * 
	 * @return Boolean
	 * 
	 */
	public static Boolean isExist(String sql, Connection conn,Object... obj) {
		ResultSet rs = null;
		try {
			rs = executeQuery(sql, conn,obj);
			rs.last();
			int count = rs.getRow();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException err) {
			err.printStackTrace();
			free(rs);
			return false;
		} 
		finally 
		{
			free(rs);
		}
	}

	/**
	 * 
	 * 获取查询记录的总行数
	 * @param sql
	 * @param obj
	 * @return int
	 */
	public static int getCount(String sql, Connection conn,Object... obj) {
		int result = 0;
		ResultSet rs = null;
		try {
			rs = executeQuery(sql, conn,obj);
			rs.last();
			result = rs.getRow();
		} catch (SQLException err) {
			err.printStackTrace();
		} finally {
			free(rs);
		}
		return result;
	}//end getCount()

	/**
	 * 
	 * 释放【ResultSet】资源
	 * @param rs
	 * 
	 */
	public static void free(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}

	/**
	 * 释放【Statement】资源
	 * @param st
	 * 
	 */

	public static void free(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}

	/**
	 * 
	 * 释放【Connection】资源
	 * @param conn
	 * 
	 */

	public static void free(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 释放所有数据资源
	 * 
	 * @param rs
	 * @param st
	 * @param conn
	 * 
	 */

	public static void free(ResultSet rs, Statement st, Connection conn) {
		free(rs);
		free(st);
		free(conn);
	}

}// end Class
