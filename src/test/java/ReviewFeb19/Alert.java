package ReviewFeb19;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {
	

	WebDriver driver;
	WebDriverWait wait;
	String firstAlert;
	
	@BeforeMethod
	public void beforeMethod() {
		
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void test1() {
		//first alert click
		driver.findElement(By.id("alertButton")).click();
		firstAlert = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		//second
		driver.findElement(By.id("timerAlertButton")).click();;
		driver.switchTo().alert().accept();
		
		//third
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirmResult")).isDisplayed();
		
		//forth
		driver.findElement(By.id("promtButton")).click();
		driver.switchTo().alert().sendKeys("HelloWorld");
		driver.switchTo().alert().accept();
		
	}
}
