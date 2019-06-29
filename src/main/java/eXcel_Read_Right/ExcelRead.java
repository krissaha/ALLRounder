package eXcel_Read_Right;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	

	public static void main(String[] args) throws IOException 
	{
		XSSFCell cell;
		File src = new File("/Users/krishnendu/eclipse-workspace/PracticeTest/src/main/java/Data/HW_DATA.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		//int rowcount = sheet.getLastRowNum();
		//System.out.println("Total row count :- " + rowcount);
		
		//Create a loop over all the rows of excel file to read it
		for (int i=0;i<sheet.getLastRowNum()+1;i++)
		{
			Row row = sheet.getRow(i);
			
			//Create a loop to print cell values in a row
			for (int j=0; j<row.getLastCellNum(); j++)
			{
//				int type = row.getCellType(j);
				cell = (XSSFCell) row.getCell(j);
				System.out.print(cell+"|");
				
				
				
				
				
			}
			System.out.println();
		}
}
}
//String s1 = sheet1.getRow(6).getCell(0).getStringCellValue();
//System.out.println("Data read :- " + s1);
