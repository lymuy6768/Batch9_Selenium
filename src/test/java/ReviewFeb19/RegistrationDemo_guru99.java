package ReviewFeb19;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationDemo_guru99 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@Test
	public void test1() {
		
		//frist name
		driver.findElement(By.name("firstName")).sendKeys("Lymuy");
		
		//last name
		driver.findElement(By.name("lastName")).sendKeys("Heng");
		
		//phone number
		driver.findElement(By.name("phone")).sendKeys("2021234567");
		
		//email
		driver.findElement(By.id("userName")).sendKeys("abcyo@gmail.com");
		
		//address
		driver.findElement(By.name("address1")).sendKeys("8888 Rosemary Ave");
		
		//city
		driver.findElement(By.name("city")).sendKeys("Washinton");
		
		//state
		driver.findElement(By.name("state")).sendKeys("DC");
		
		//postal
		driver.findElement(By.name("postalCode")).sendKeys("20008");
		
		WebElement country= driver.findElement(By.name("country"));
		Select dropcountry= new Select(country);
		dropcountry.selectByVisibleText("UNITED STATES");
		
		//username
		driver.findElement(By.name("email")).sendKeys("abcyo@gmail.com");
		
		//password
		driver.findElement(By.name("password")).sendKeys("789yoyo@");
		
		//confirm password
		driver.findElement(By.name("confirmPassword")).sendKeys("789yoyo@");
		
		//submit
		driver.findElement(By.name("submit")).click();
		
	}

}
