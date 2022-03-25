package Day3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyAccountLogin_8 {
/*	1) Open the browser
	2) Enter the URL “http://practice.automationtesting.in/”
	3) Click on My Account Menu
	4) Enter the case changed username in username textbox
	5) Enter the case chenged password in the password tetxbox
	6) Now click on login button
	7) Once your are logged in, sign out of the site
	8) Now press back button
	9) User shouldn’t be signed in to his account rather a general webpage must be visible*/

	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://practice.automationtesting.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	@Test
	public void test1(){
		//click on My Account
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		
		//abcyoo@gmail.com, javaihateu2022$
		//username
		driver.findElement(By.id("username")).sendKeys("abcyoo@gmail.com");
		
		//password
		driver.findElement(By.id("password")).sendKeys("javaihateu2022$");
		
		//log in
		driver.findElement(By.name("login")).click();
		
		//log out
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[6]/a")).click();
		
	}
	
	}
