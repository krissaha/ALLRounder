package com.qa.test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DiffExplicitWait {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;

	@Test
	public void login() throws Exception {

			try {

			// Initialization of properties file
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"E:/Selenium/PracticeTest/src/main/java/com/qa/config/Config.properties");
			prop.load(ip);
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe"); // Launching
			driver = new ChromeDriver();
			driver.get(prop.getProperty("Url")); // Launching url
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(prop.getProperty("Email")); // Entering
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(prop.getProperty("Password"));
			String hiddenCaptchaVal = ""; // Enter Captcha
			hiddenCaptchaVal = driver.findElement(By.id("HiddenCaptcha")).getAttribute("value");
			driver.findElement(By.id("Captcha")).sendKeys(hiddenCaptchaVal);
			
			explicitclick(driver, By.xpath("//input[@id='btnLogin']"));
			WebElement actual = driver.findElement(By.xpath("//a[@class='logoarea']"));
			Assert.assertTrue(actual.isDisplayed());
			// Select Customer Tricorbraun
			Select oS = new Select(driver.findElement(By.id("SelectedCompanyId")));
			oS.selectByValue("5791");
			explicitclick(driver, By.className("newsc"));
			String s = "Dashboard";
			Assert.assertEquals(s, driver.getTitle());
			explicitclick(driver, By.xpath("//span[contains(text(),'Shipment')]"));
			explicitclick(driver,
			By.xpath("//div[@class='dropdown slick-slide slick-active' and @data-slick-index='1']"));
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,-2000)");
			explicitclick1(driver, By.xpath("//div[@class='show-sidebar']"));
			
			explicitclick(driver, By.xpath("//span[contains(text(), '- Select Branch -')]"));
			explicitclick(driver,(By.xpath("//ul[@id='BranchKey_listbox']//child::li[3]")));
			explicitclick(driver,(By.xpath("//span[contains(text(), '- Select -')]")));
			explicitclick(driver,By.xpath("//ul[@id='ShipmentType_listbox']//child::li[2]"));
			explicitclick(driver,(By.xpath("//span[contains(text(), '- Select - ')]")));
			explicitclick(driver,By.xpath("//ul[@id='RatingPreferences_listbox']//child::li[2]"));
			explicitclick(driver,By.xpath("//div[@class='col-xs-7 col-md-7 padleftres']//span[contains(text(), '- Select -')]"));
	
			driver.findElement(By.xpath("//ul[@id='ShipmentTerms_listbox']//child::li[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[contains(text(),'Add New Orgin/Destination')]")).click();
			Thread.sleep(2000);

			// Add Origin details
			WebDriverWait wait5 = new WebDriverWait(driver, 5);
			wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Both')]")));
			driver.findElement(By.xpath("//span[contains(text(),'Both')]")).click();
			// driver.findElement(By.xpath("//span[contains(text(),'Both')]")).click();
			// Thread.sleep(5000);
			driver.findElement(By.xpath("//ul[@id='ddlStopType_listbox']//child::li[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@id='lookupLocationID']")).click();
			Thread.sleep(5000);
			// Select details from the child window
			driver.findElement(By.xpath("//div[@id='modalDialog']//span[contains(text(), '- Select -')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//ul[@id='LocationCountry_listbox']//child::li[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='modalDialog']//button[@id='btnLocationSearch']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@id='Location']/div[3]/table/tbody/tr[1]/td[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[@id='Select']")).click();
			Thread.sleep(5000);
			// Calender input code!!
			driver.findElement(
					By.xpath("//*[@id='frmInnerGrid']/div/div/div[1]/div[1]/div/div[2]/span/span/span/span[1]"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='k-animation-container']//a[@class='k-link k-nav-today']"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By
					.xpath("//a[@id='btnEdit' and @class='k-button k-button-icontext k-primary k-grid-update btnEdit']"))
					.click();
			Thread.sleep(7000);

			// Add Destination details
			driver.findElement(By.xpath("//a[contains(text(),'Add New Orgin/Destination')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[contains(text(),'Both')]")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//ul[@id='ddlStopType_listbox']//child::li[3]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@id='lookupLocationID']")).click();
			Thread.sleep(4000);
			// Select details from the child window
			driver.findElement(By.xpath("//div[@id='modalDialog']//input[@id='LocId']")).sendKeys("DEN USAUR");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='modalDialog']//button[@id='btnLocationSearch']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='Location']/div[3]/table/tbody/tr[3]/td[1]/input")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[@id='Select']")).click();
			Thread.sleep(5000);
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,200)");
			Thread.sleep(5000);
			// Calender input code!!
			driver.findElement(By.xpath("//input[@id='ShipperRequestedDeliveryDate_2_2']")).sendKeys("1/10/2019");
			Thread.sleep(2000);
			driver.findElement(By
					.xpath("//a[@id='btnEdit' and @class='k-button k-button-icontext k-primary k-grid-update btnEdit']"))
					.click();
			Thread.sleep(7000);

			// Add New Product Details
			driver.findElement(By
					.xpath("//div[@id='ShipmentProductGrid']//div[@class='k-header k-grid-toolbar k-grid-top']//a[contains(@class,'k-button k-button-icontext')]"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@name='txtProduct']")).sendKeys("ABCDEFGH");
			driver.findElement(By.xpath("//input[@name='txtProductDtlsID']")).sendKeys("ABCDEFGH");
			// Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='Quantity']")).sendKeys("10");
			// Thread.sleep(3000);
			driver.findElement(By.xpath("//span[contains(text(),'- Select -  ')]")).click();
			Thread.sleep(3000);
			// Unit Of Measure
			driver.findElement(
					By.xpath("//ul[@id='UnitMeasurelookup_listbox']//li[@class='k-item'][contains(text(),'Bag')]"))
					.click();
			driver.findElement(By.xpath("//input[@id='Weight']")).sendKeys("10");
			Thread.sleep(3000);
			// Weight Unit Of Measure
			driver.findElement(By.xpath("//span[contains(text(),'- Select -  ')]")).click();
			Thread.sleep(2000);
			driver.findElement((By.xpath("//ul[@id='WeigthUomlookup_listbox']//child::li[2]"))).click();
			// Billed Quantity
			driver.findElement(By.xpath("//input[@id='BillQty']")).sendKeys("10");
			driver.findElement(By.xpath("//input[@id='Length']")).sendKeys("10");
			driver.findElement(By.xpath("//input[@id='Width']")).sendKeys("10");
			driver.findElement(By.xpath("//input[@id='Height']")).sendKeys("10");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[contains(text(),'- Select -  ')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//ul[@id='DimUomlookup_listbox']//child::li[2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Update")).click();
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//div[@class='dropdown slick-slide slick-active']//span[contains(text(),'Save')]"))
					.click();
			Thread.sleep(3000);
			// Switching to Alert
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Thread.sleep(10000);
			// Success! Shipment Successfully Updated.
			WebElement elesucc = driver.findElement(By.xpath("//div[@id='result_info']"));
			Assert.assertTrue(elesucc.isDisplayed());
			System.out.println(elesucc.getText());
			Thread.sleep(2000);

			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}

	}

	public static void explicitclick(WebDriver driver, By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}
	
	public static void explicitclick1(WebDriver driver, By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
		driver.findElement(by).click();
	}
	
}
