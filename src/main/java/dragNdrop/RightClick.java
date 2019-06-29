package dragNdrop;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RightClick
{
public static WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/krishnendu/Selenium/chromedriver");
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void takeScreenShot1() throws InterruptedException
	{
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement E1 = driver.findElement(By.cssSelector(".context-menu-one"));
		Actions action = new Actions(driver);
		action.contextClick(E1).build().perform();
		
		WebElement copy = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
		copy.click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(5000);
		
	}
}
