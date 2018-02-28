package factory;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

public class DataProviderFactory {
	
		//this step is optional
		//it will create object and return object directly
		
		public static ConfigDataProvider getconfig(){
			ConfigDataProvider config=new ConfigDataProvider();
			return config;
		}
		
		public static ExcelDataProvider getexcel(){
			ExcelDataProvider excel=new ExcelDataProvider();
			return excel;
		}

}
