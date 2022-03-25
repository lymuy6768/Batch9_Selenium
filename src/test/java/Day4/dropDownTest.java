package Day4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropDownTest {
WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
//		1) Open the browser
//		2) Enter the URL “http://the-internet.herokuapp.com//”
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//use only when open browser,or navigate to new page. we dont use it in any 
		//other task
		
	}
	
	@Test
	public void staticDropDown() throws InterruptedException {
		
		WebElement staticDropdown= driver.findElement(By.id("dropdown"));
		Select select = new Select(staticDropdown);
		
		select.selectByIndex(1);
		Thread.sleep(3000);
		select.selectByValue("2");
		Thread.sleep(3000);
		select.selectByVisibleText("Option 1");
		Thread.sleep(3000);
	}

}
