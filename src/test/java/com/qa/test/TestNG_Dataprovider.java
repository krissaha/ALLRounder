package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_Dataprovider {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/krishnendu/Selenium/chromedriver 3");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}

	@Test(dataProvider = "facebookLogin")
	public void testFaceBook(String email,String password) {
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
	
		driver.findElement(By.xpath("//input[@id='pass']")).clear();
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@DataProvider(name = "facebookLogin")
	public static Object[][] getDataFromDataprovider() {
		return new Object[][] {{ "test@test.com", "Test123" }, { "Test@test123.com", "pass@123" },
				{ "Test@data.com", "pass@1231" }};
	}
}
