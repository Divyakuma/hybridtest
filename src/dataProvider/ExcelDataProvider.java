package dataProvider;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		File src=new File("D:\\DivyaBackup\\workspace\\ProjectPractice2\\ApplicationData\\user.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is: "+e.getMessage());
		}
		
	}
	
	public String getdata(int sheetindex,int row,int col)
	{
		return wb.getSheetAt(sheetindex).getRow(row).getCell(col).getStringCellValue();
	}
	
	public String getdata(String sheetname,int row,int col)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}

}
