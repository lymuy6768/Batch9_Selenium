package Day4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class implicitWaitExample {
	
WebDriver driver;
WebDriverWait wait;
	
	@BeforeMethod
	public void beforeMethod() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//use only when open browser,or navigate to new page. we dont use it in any 
		//other task

	}
	@Test
	public void explicitWaitTest1() {
		//login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		//initiating explicit wait object
		wait = new WebDriverWait(driver,30);
		
		//waiting for the element to be visible
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));
		
		
		
		String actualWelcomeText=driver.findElement(By.id("welcome")).getText();
		String expected = "Welcomje Paul";
		
		if(actualWelcomeText.equalsIgnoreCase(expected)){
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
	}
	@Test
	public void fluentWaitTest() {
		
		Wait wait = new FluentWait(driver)
				.withTimeout(30,TimeUnit.SECONDS)//waittime up 30 seconds
				.pollingEvery(5, TimeUnit.SECONDS)//frency checking 5 second, so 6 time in 30 second
				.ignoring(Exception.class);//ignoring whatever exception in this class
		
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	
	
	
	
	
	

}
