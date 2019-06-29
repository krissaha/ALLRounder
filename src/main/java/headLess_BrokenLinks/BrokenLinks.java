package headLess_BrokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws Throwable 
	{
		
		String testUrl = "http://www.theavinashmishra.com/";
		 
		 HttpURLConnection urlCon = null;
		 
		 int statusCode = 200; //It means in general URL is OK
		 
		 System.setProperty("webdriver.chrome.driver", "/Users/krishnendu/Selenium/chromedriver 3");
		    
		 WebDriver driver  = new ChromeDriver();
		   
		   	driver.get(testUrl);
		   
		     driver.manage().window().maximize();
		     
		     Thread.sleep(2000);
		 
		   	List<WebElement> linkList = driver.findElements(By.tagName("a"));
		   	List<String> validURL = new ArrayList<String>();
		   	List<String> brokenURL = new ArrayList<String>();
		   	
		   	for(WebElement e : linkList){
		    String urls = e.getAttribute("href");
		    
		    
		    if(!(urls==null) && !urls.isEmpty()){
		    
		    //Look for the same domain URL only
		    
		    if(urls.startsWith(testUrl)){
		    
		    try{
		    URL url = new URL(urls);
		    urlCon = (HttpURLConnection)(url.openConnection());
		    urlCon.setRequestMethod("HEAD");
		    urlCon.connect();
		    statusCode = urlCon.getResponseCode();
		    if(statusCode>=400){
		    System.out.println("This is client side error, hence, page is broken "+
		                             "\n Broke URL is- "+url+
		                             " \n Its status code is- "+statusCode);
		    brokenURL.add(urls);
		    }else if(statusCode>=500){
		    System.out.println("This is server side error, hence, page is broken "+
		                          "\n Broke URL is- "+url+
		                          " \n Its status code is- "+statusCode);
		    brokenURL.add(urls);
		    }else {
		    System.out.println("This is valid URL- "+urls);
		    validURL.add(urls);
		    
		    }
		    }catch(MalformedURLException e0){
		    e0.printStackTrace();
		    }catch(IOException e1){
		    e1.printStackTrace();
		    }catch(Exception e3){
		    e3.printStackTrace();
		    }
		    } 
		    }
		    
		   	}
		   	
		   	driver.close();
		   	driver.quit();
		
	}

}
