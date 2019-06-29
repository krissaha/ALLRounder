package eXcel_Read_Right;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XcelToMAp {
	public static Map<String, Map<String, String>> setMapData(String sheetName, String rowName, String colNum) throws IOException {
		// Configuring and connecting the excel file
		String path = "/Users/krishnendu/eclipse-workspace/ALLRounder/src/main/java/com/qa/data/Automation_Test-Data.xlsx";
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetName);
		XSSFRow row;
		row = (XSSFRow) sheet.getRow(0);
		
		// Counting number of rows in the current Sheet
		int lastRow = sheet.getLastRowNum();

		// Creating HashMap 1 (Excel file name with data map)
		Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String, String>>();

		// Creating HashMap 2 (Test data map)
		Map<String, String> dataMap = new HashMap<String, String>();
		
		int numCols = sheet.getRow(0).getLastCellNum();
		int col_Num = -1;
		// Create a loop to read the column number from which user want to read.
				for (int i = 0; i < numCols; i++) {
					if (row.getCell(i).getStringCellValue().trim().equals(colNum.trim()))
						col_Num = i;
				}

		// Looping over entire row
		for (int i = 0; i <= lastRow; i++) 
			{
				row = (XSSFRow) sheet.getRow(i);
				
				// Row as Key
				Cell keyCell = row.getCell(0);
				
				// Column as Value
				Cell valueCell = row.getCell(col_Num);

				String value = valueCell.getStringCellValue().trim();
				String key = keyCell.getStringCellValue().trim();

				// Putting key & value in dataMap
				dataMap.put(key, value);

				// Putting dataMap to excelFileMap
				excelFileMap.put("DataSheet", dataMap);
			}
		//Returning excelFileMap
		 return excelFileMap;
	}
	
	//Method to retrieve value
	 public static String getMapData(String key) throws IOException{
	 
	 Map<String, String> m = setMapData("SignUP").get("DataSheet");
	 String value = m.get(key);
	 return value;
	 }
	 
	 public static void main(String args[]) throws Throwable
	 {
		 String val = getMapData("TD01");
		 System.out.println("Value of the keyword (search) is- "+val);

	 }

}
