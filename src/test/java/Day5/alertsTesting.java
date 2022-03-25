package Day5;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alertsTesting {
WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
//		1) Open the browser
//		2) Enter the URL “http://the-internet.herokuapp.com//”
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
		@Test
	    public void alert1() {
	        driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button")).click();
	        String firstAlertText = driver.switchTo().alert().getText();
	        System.out.println(firstAlertText);
	        driver.switchTo().alert().accept();
	    
	}
		@Test
	    public void alert2() {
	        driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();
	        String secondAlertText = driver.switchTo().alert().getText();
	        System.out.println(secondAlertText);
	        driver.switchTo().alert().dismiss();
		}
		@Test
	    public void alert3() {
	        driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button")).click();
	        String thirdAlertText = driver.switchTo().alert().getText();
	        System.out.println(thirdAlertText);
	        
	        String enteredTest="Batch9";
	        driver.switchTo().alert().sendKeys(enteredTest);
	        driver.switchTo().alert().accept();
	        
	        String actualTextRetrieved= driver.findElement(By.id("//*[@id='result']")).getText();
	        
	        if(actualTextRetrieved.contains(enteredTest)) {
	        	System.out.println("Prompt Took the text successfully and displayed it on the page");
	        }
	
		}	

}
