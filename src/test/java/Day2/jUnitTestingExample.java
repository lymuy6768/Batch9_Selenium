package Day2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jUnitTestingExample {
	
	@BeforeMethod
	public void setUp() {
	/*	WebDriver driver;//create an object
		WebDriverManager.chromedriver().setup();	
		
		driver= new ChromeDriver();//invoke the browser , a blank browser open
		driver.get("https://www.techcircleschool.com");//open url in browser*/
		System.out.println("Opening Browser");
		
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing Browser");
	}
	
	
	

	@Test
	public void test1() {
		System.out.println("Test");
	}
	@Test
	public void test2() {
		System.out.println("Test2");
	}
	

}
