package Day4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicSelect {
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//wait for all the pages loaded
		
	}
	@Test
	public void bookingDynamic() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.id("root")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/label/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys("IAD");
		Thread.sleep(2000);
		driver.findElement(By.linkText("IAD, Washington Dulles International Airport United States")).click();
		
		
//		Select select= new Select(dropDown);
//		select.selectByValue("San Francisco");
		
	}

}
