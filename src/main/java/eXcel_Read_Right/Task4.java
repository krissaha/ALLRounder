package eXcel_Read_Right;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Task4 {

	public static Map<String, Map<String, String>> setMapData() throws IOException {

		XSSFCell cell;
		XSSFRow row, row1;
		File src = new File("/Users/krishnendu/eclipse-workspace/PracticeTest/src/main/java/Data/Test_Data.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();

		Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String, String>>();
		Map<String, String> dataMap = new HashMap<String, String>();

		// Looping over entire row
		for (int i = 0; i <= lastRow; i++) {

			Row row = sheet.getRow(i);

			// 1st Cell as Value
			Cell valueCell = row.getCell(1);

			// 0th Cell as Key
			Cell keyCell = row.getCell(0);

			String value = valueCell.getStringCellValue().trim();
			String key = keyCell.getStringCellValue().trim();

			// Putting key & value in dataMap
			dataMap.put(key, value);

			// Putting dataMap to excelFileMap
			excelFileMap.put("DataSheet", dataMap);
		}

		// Returning excelFileMap
		return excelFileMap;

	}

	public static void main(String[] args) {

	}

}
