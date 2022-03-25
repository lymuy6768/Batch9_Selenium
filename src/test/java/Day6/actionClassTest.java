package Day6;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class actionClassTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@Test
	public void test1() {
		
		Actions action = new Actions(driver);// declare and initialize and action object, driver instance
	
		WebElement accountListButton= driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
		
		action.moveToElement(accountListButton).build().perform();
		
		
	
	}
}
