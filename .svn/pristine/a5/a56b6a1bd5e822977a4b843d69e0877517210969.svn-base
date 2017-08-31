package cauc.edu.cn.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils 
{
	
	public static final String jdbcConfig = "jdbc.properties";
	public static final String imageConfig = "imageServer.properties";
	
	private static Properties jdbcProperties = new Properties();
	private static Properties imagejdbcProperties = new Properties();
	
	static
	{
		//类加载器加载类的时候，该语句块中的代码就会被执行
		readProperties();
	}
	
	public static String getJdbcProperties(String key)
	{
		return jdbcProperties.getProperty(key);
	}
	public static String getImageProperties(String key)
	{
		return imagejdbcProperties.getProperty(key);
	}
	
	
	
	private static  void readProperties()
	{
		InputStream resourceAsStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(jdbcConfig);
		InputStream resourceAsStream1 = PropertiesUtils.class.getClassLoader().getResourceAsStream(imageConfig);
		try 
		{
			jdbcProperties.load(resourceAsStream);
			imagejdbcProperties.load(resourceAsStream1);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
