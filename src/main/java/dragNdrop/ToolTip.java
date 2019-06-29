package dragNdrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ToolTip {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/krishnendu/Selenium/chromedriver 3");

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.inviul.com/blog/");

		driver.manage().window().maximize();

		Thread.sleep(2000);

		WebElement ele = driver.findElement(By.xpath("//*[@class='social-facebook']//a"));

		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();

		Thread.sleep(2000);

		String tootltipText = ele.getAttribute("title");

		String expectedText = "Facebook";

		System.out.println("Tooltip Text is- " + tootltipText);

		Assert.assertEquals(expectedText, tootltipText);

		driver.close();

		driver.quit();

	}
}
