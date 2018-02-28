package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider()
	{
		File src =new File("D:\\DivyaBackup\\workspace\\ProjectPractice2\\Configuration\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			
			 pro=new Properties();
			 
			 pro.load(fis);
		
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	public String getURL()
	{
		String url=pro.getProperty("url");
		return url;
	}
	
	public String getChromepath()
	{
		String chrome=pro.getProperty("chrome");
		return chrome;
	}
}
