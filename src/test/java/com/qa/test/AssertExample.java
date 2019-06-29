package com.qa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertExample
{
	@Test
	  public void assertTestMethod() {
	   
	   System.setProperty("webdriver.chrome.driver", "/Users/krishnendu/Selenium/chromedriver 3");
	    
	  	  WebDriver driver = new ChromeDriver();
	   
	  	  driver.get("http://www.facebook.com/");
	   
	  	  driver.manage().window().maximize();
	  	  
	  	  String expectedTitle = "Testing";
	  	  
	  	  Assert.assertEquals(driver.getTitle(), expectedTitle, "Title didn't match");
	  	
	  	  driver.close();
	   
	   driver.quit();

}
}

