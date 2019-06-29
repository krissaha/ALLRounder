package screenShoot_Recording;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenShotUsingRobot {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/Users/krishnendu/Selenium/chromedriver 3");
		   
		   WebDriver driver = new ChromeDriver();
		 
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   driver.get("http://www.inviul.com/");
		   
		   driver.manage().window().maximize();
		   
		   
		   //Screenshot Capture Command
		   
		   //Robot Class Initialization
		   Robot robot = new Robot();
		   
		 //Rectangle Class Initialization
		   Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		   
		 //Defining Output files destination
		   File destFile = new File("/Users/krishnendu/Downloads/RobotImage");
		   
		   //Screenshot Capture
		   BufferedImage img = robot.createScreenCapture(rect);
		   
		   //Writing image to destination with its formats
		   ImageIO.write(img, "png", destFile);
		   
		   driver.close();
		   
		   driver.quit();
	}

}
