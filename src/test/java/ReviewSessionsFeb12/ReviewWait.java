package ReviewSessionsFeb12;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReviewWait {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void beforeMethod() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	@Test
	public void test1() {
		driver.findElement(By.name("q")).sendKeys("TechCircle School", Keys.ENTER);
		
		wait = new WebDriverWait(driver,30);//instance driver to wait for browser to load
		
		WebElement resultText = driver.findElement(By.id("result-stats"));
		wait.until(ExpectedConditions.visibilityOf(resultText));
		
		System.out.println(resultText.getText());
		
		//Thread.sleep(3000);// hard code use only for your own code
		
		
	}
}
