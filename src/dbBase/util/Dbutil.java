package dbBase.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Dbutil {  
	public static String driver="";
	public static String url="";
	public static String user="";
	public static String pwd="";
	public static String driver2="";
	public static String url2="";
	public static String user2="";
	public static String pwd2="";
	static Properties properties = new Properties();
	static String str = System.getProperty("user.dir") + File.separator
			+ "application.properties";
	static {
		File file = new File(str);
		FileInputStream fileinput;
		try {
			fileinput = new FileInputStream(file);
			properties.load(fileinput);
			driver=properties.getProperty("jdbc.driver");
			url=properties.getProperty("jdbc.url");
			user=properties.getProperty("jdbc.username");
			pwd=properties.getProperty("jdbc.password");
			
			driver2=properties.getProperty("driver");
			url2=properties.getProperty("url");
			user2=properties.getProperty("username");
			pwd2=properties.getProperty("password");
		} catch (FileNotFoundException e) {
			System.out.println("获取文件出错 :  "+e.getMessage());
		} catch (IOException e) {
			System.out.println("文件加载出错 :  "+e.getMessage());
		}

	}
}
