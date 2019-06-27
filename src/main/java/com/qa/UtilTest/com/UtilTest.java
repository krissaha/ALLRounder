package com.qa.UtilTest.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.qa.base.TestBase;

public class UtilTest extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 15;

	public static String t = "";

	public static void sendkeys(WebDriver driver, WebElement element, String value) {
		int timeout = Integer.parseInt(prop.getProperty("Explicitwait"));
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	public static void element_click(WebDriver driver, WebElement element) {
		int timeout = Integer.parseInt(prop.getProperty("Explicitwait"));
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static void scrollDown(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Ele = element;
		js.executeScript("arguments[0].scrollIntoView();", Ele);
	}

	public static void select_dropdown(WebElement element, String value) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select os = new Select(element);
		os.selectByVisibleText(value);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String emailidgenerate() {
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
		Date date = new Date();
		String t = dateFormat.format(date);
		String beforet = "krishnendu+";
		String aftert = "@tiatros.com";
		String time = beforet.concat(t).concat(aftert);
		System.out.println(time);
		return time;
	}

	public static void by_click(WebDriver driver, By element1) {
		int timeout = Integer.parseInt(prop.getProperty("Explicitwait"));
		WebElement element = driver.findElement(element1);
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public static String readExcel(String sheetName, String rowName, String colNum) throws Throwable {

		XSSFCell cell;
		XSSFRow row;
		File src = new File(prop.getProperty("ExcelPath"));
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int numRows = sheet.getLastRowNum() + 1;
		int numCols = sheet.getRow(0).getLastCellNum();
		row = sheet.getRow(0);
		int col_Num = -1;
		String ret = "";

		// Create a loop to read the column number from which user want to read.
		for (int i = 0; i < numCols; i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colNum.trim()))
				col_Num = i;
		}

		for (int j = 1; j <= numRows; j++) {
			if (rowName.equals(sheet.getRow(j).getCell(0).getStringCellValue())) {
				cell = sheet.getRow(j).getCell(col_Num);

				if (cell.getCellType() == CellType.STRING) {
					ret = cell.getStringCellValue();
					// System.out.println(ret);
					break;
				}

				else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

					String cellText = String.valueOf(cell.getNumericCellValue());
//					if (HSSFDateUtil.isCellDateFormatted(cell)) {
//						// format in form of M/D/YY
//						double d = cell.getNumericCellValue();
//						Calendar cal = Calendar.getInstance();
//						cal.setTime(HSSFDateUtil.getJavaDate(d));
//						cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
//						cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
					int index = cellText.indexOf(".");
					ret = cellText.substring(0, index);
					// System.out.println(ret);
					break;

				}
			}
			wb.close();
		}
		return ret;
	}

	public static void takeScreenshot(String testMethodName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,
					new File("/Users/krishnendu/eclipse-workspace/Tiatros/Screenshots/" + testMethodName + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object[][] readExcel(String sheetName) throws Throwable {

		XSSFCell cell;
		File src = new File(prop.getProperty("ExcelPath"));
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int numRows = sheet.getLastRowNum() + 1;
		int numCols = 11;// sheet.getRow(0).getLastCellNum();
		Object[][] ob = new Object[numRows][numCols];

		// Create a loop to read the row values
		for (int i = 1; i < numRows; i++) {
			Row row = sheet.getRow(i);

			// Create a loop to read cell values in a row
			for (int j = 0; j < numCols; j++) {

				cell = (XSSFCell) row.getCell(j);
				System.out.print(cell + "|");
				ob[i][j] = cell;
			}
			System.out.println();
		}
		wb.close();
		return ob;
		
	}

	public static String title() {
		String t = driver.getTitle();
		return t;
	}

	public static String generate_message_subject() {
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
		Date date = new Date();
		String t = dateFormat.format(date);
		String beforet = "My Dear Messengers .... ";
		String messageSub = beforet.concat(t);
		return messageSub;
	}

	public static void message_Post_Verification() {
		WebElement ele = driver
				.findElement(By.xpath("//div[contains(@id,'message_post_item')]//h3[contains(text(),'" + t + "')]"));
		boolean vt = ele.isDisplayed();
		Assert.assertEquals(vt, true, "Uploaded Text Not Found");

	}

	public static void message_Post_click() {
		driver.findElement(By.xpath("//div[contains(@id,'message_post_item')]//h3[contains(text(),'" + t + "')]"))
				.click();

	}

	public static void acceptPopUP() {
		// Switching to Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void dismissPopUP() {
		// Switching to Alert
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public static void click_hambergur() {
		driver.findElement(By.xpath("//a[@class='navbar-minimalize minimalize-styl-2 btn']")).click();
	}

	public static void logout() {
		driver.findElement(By.xpath("//span[@class='nav-label text-danger']")).click();
	}

	public static void loveIcon() {
		// Take the total count of Love Hearts
		int totalheart = driver.findElements(By.xpath("//*[contains(@class,'text-danger m-r-sm')]")).size();

		// This loop will run till the number of Love Icons found in the page found
		for (int i = 1; i <= totalheart; i++) {
			try {
				driver.findElement(By.xpath("//div[contains(@id,'message_post_item')][" + i
						+ "]/div/child::div/div//a[contains(@class,'text-danger m-r-sm')]/i[@class='fa fa-heart-o fa-2x']"))
						.click();
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public static void clickonTiles() {
		// Take the total count of the total tiles of the page
		int totalTiles = driver.findElements(By.xpath(
				"//div[contains(@id,'message_post_item')]/div/a[@class='panel-heading message-panel block clearfix']"))
				.size();

		// This loop will run till the number of Love Icons found in the page found
		for (int i = 1; i <= totalTiles; i++) {
			try {
				driver.findElement(By.xpath("//div[contains(@id,'message_post_item')][" + i
						+ "]/div/a[@class='panel-heading message-panel block clearfix']")).click();
				Thread.sleep(3000);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public static void clickPagination_AllTiles() {
		// Take the total count of the total tiles of the page
		int totalPagination = driver.findElements(By.xpath("//div[@class='pagination pull-right no-margin']/div/li"))
				.size();
		totalPagination = totalPagination - 3;

		// This loop will run till the number of pagination found in the page found

		for (int j = 1; j <= totalPagination; j++) {

			// Take the total count of the total tiles of the page
			int totalTiles = driver.findElements(By.xpath(
					"//div[contains(@id,'message_post_item')]/div/a[@class='panel-heading message-panel block clearfix']"))
					.size();

			// This loop will run till the number of Love Icons found in the page found
			for (int i = 1; i <= totalTiles; i++) {
				try {
					Thread.sleep(3000);
					driver.findElement(By.xpath("//div[contains(@id,'message_post_item')][" + i
							+ "]/div/a[@class='panel-heading message-panel block clearfix']")).click();
					Thread.sleep(3000);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}

			driver.findElement(
					By.xpath("//div[@class='pagination pull-right no-margin']/div/li/a[contains(text(),'Next →')]"))
					.click();
		}

	}

	public static void counterCheck(String icon) {
		String beforeNum = driver.findElement(By.xpath(
				"//div[contains(@class,'ibox float-e-margins')]//li//a[contains(@data-original-title,'" + icon + "')]"))
				.getText();
		int bNum = Integer.parseInt(beforeNum);
		System.out.println(bNum);

		// Take the total count of the total tiles of the page
		int totalTiles = driver.findElements(By.xpath(
				"//div[contains(@id,'message_post_item')]/div/a[@class='panel-heading message-panel block clearfix']"))
				.size();

		// This loop will run till the number of Love Icons found in the page found
		for (int i = 1; i <= totalTiles; i++) {
			try {
				driver.findElement(By.xpath("//div[contains(@id,'message_post_item')][" + i
						+ "]/div/a[@class='panel-heading message-panel block clearfix']")).click();
				Thread.sleep(3000);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		String afterNum = driver.findElement(By.xpath(
				"//div[contains(@class,'ibox float-e-margins')]//li//a[contains(@data-original-title,'" + icon + "')]"))
				.getText();
		int aNum = Integer.parseInt(afterNum);
		System.out.println(aNum);

		if (bNum > aNum) {
			Assert.assertEquals(true, true);
		} else {
			Assert.assertEquals(false, true, "-----Notification Message not reduced-----");
		}

	}

	public static void clickReportAlert() {
		// Take the total count of the total reportAbouse of the page
		int totalreportAbouse = driver
				.findElements(By.xpath("//*[@class='btn btn-xs pull-right'][contains(text(),'Report')]")).size();

		// This loop will run till the number of Love Icons found in the page found
		for (int j = 1; j <= totalreportAbouse; j++) {
			try {
				driver.findElement(By.xpath("//*[contains(@id,'message_post_item')][" + 1
						+ "]//*[@class='btn btn-xs pull-right'][contains(text(),'Report')]")).click();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public static void fetchValue(String PStage) {
		
		System.out.println("Data Fetched :- " + PStage);
		for (int i = 1; i <= 4; i++) {
			String value;
			switch (i) {
			case 1:
				value = driver.findElement(By.xpath(
						"//table[@class='table table-bordered validative-masure']//tbody/tr/*[contains(text(),'"+PStage+"')]//following::*["
								+ i + "]"))
						.getText();
				System.out.println("PSS10 = " + value);
				break;

			case 2:
				value = driver.findElement(By.xpath(
						"//table[@class='table table-bordered validative-masure']//tbody/tr/*[contains(text(),'"+PStage+"')]//following::*["
								+ i + "]"))
						.getText();
				System.out.println("GAD7 = " + value);
				break;
			case 3:
				value = driver.findElement(By.xpath(
						"//table[@class='table table-bordered validative-masure']//tbody/tr/*[contains(text(),'"+PStage+"')]//following::*["
								+ i + "]"))
						.getText();
				System.out.println("PHQ9 = " + value);
				break;

			case 4:
				value = driver.findElement(By.xpath(
						"//table[@class='table table-bordered validative-masure']//tbody/tr/*[contains(text(),'"+PStage+"')]//following::*["
								+ i + "]"))
						.getText();
				System.out.println("PHQ15 = " + value);
				break;

			}

		}

	}

	public static void scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,5000)");
	}

}
