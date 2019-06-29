package com.qa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

import screenShoot_Recording.MyScreenRecorder;


public class ScreenRecordDemo extends TestBase
{
	public static WebDriver driver;
	
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/krishnendu/Selenium/chromedriver 3");
		driver = new ChromeDriver();
	}
	
	@Test
	public void navigation() throws Exception
	{
		MyScreenRecorder.startRecording("navigation");
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.navigate().to("https://accounts.google.com/ServiceLogin/identifier?service=cl&passive=1209600&osid=1&continue=https%3A%2F%2Fcalendar.google.com%2Fcalendar%2Frender%3Ftab%3Dwc&followup=https%3A%2F%2Fcalendar.google.com%2Fcalendar%2Frende"
				+ "r%3Ftab%3Dwc&scc=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		
		MyScreenRecorder.stopRecording();
	}
	
	@AfterMethod
	public static void teardown()
	{
		driver.quit();
	}
}
