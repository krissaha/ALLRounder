package eXcel_Read_Right;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws Exception {

		File src = new File(
				"/Users/krishnendu/eclipse-workspace/PracticeTest/src/main/java/com/qa/TestData/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("loginData");
		String data = "valid User";
		int count = 0;
		int rowcount = sheet.getLastRowNum(); // Count number of Rows

		for (int i = 0; i <= rowcount + 1; i++) {
			Row row = sheet.getRow(i);
			String rData = row.getCell(i).getStringCellValue();
			if (data == rData) {
				for (int j = i + 1; j < row.getLastCellNum(); j++) {
					System.out.print(row.getCell(j).getStringCellValue() + " | ");
					break;
				}
			} else if (count > rowcount) {
				System.out.println("Data Not Found...");
			}
			count = count + 1;
		}

		wb.close();

	}
}
