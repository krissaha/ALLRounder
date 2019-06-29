package headLess_BrokenLinks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

public class Headlessbrowser {

	public static void main(String[] args) {
		WebDriver driver  = new HtmlUnitDriver(BrowserVersion.CHROME);
		   
		   driver.get("http://www.inviul.com/blog/");
		   	  
		   	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   	  driver.manage().window().maximize();
		   	  
		   	  System.out.println("Title of the page is- "+driver.getTitle());
		    
		    driver.close();
		    
		    driver.quit();
	}

}
