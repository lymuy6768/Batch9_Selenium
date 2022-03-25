package Day6;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assertionsTest {

WebDriver driver;//create an object


	@BeforeMethod
	public void beforeMethod() {
	
		WebDriverManager.chromedriver().setup();	// webdriverManage come from libraries, declare driver
		
		//WebDriver driver =new Chromedriver(); //polyphism ,overridding 
		
		driver= new ChromeDriver();//invoke the browser , a blank browser open
		
		
		driver.get("http://the-internet.herokuapp.com/checkboxes");//open url in browser
		
		driver.manage().window().maximize();
	}
	@Test
	public void assertTestFalse() {
		WebElement checkbox1= driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		AssertJUnit.assertFalse(checkbox1.isSelected());//is selected return false, cos it is not selected
		System.out.println("hello");
		
	
		
		WebElement checkbox2= driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		AssertJUnit.assertFalse(checkbox2.isSelected());//is selected return true, cos it is selected, what we expect is not check
		System.out.println("hello");
	}
	@Test
	public void assertTrueTest() {
		
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).isDisplayed());
		
		System.out.println("code didnt throw an exception on assertTrueTest");
	}
	@Test
	public void assertEqualsTest() {//compare 2 objects
		
		String checkboxTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
		
		String expectedTitle= "Checkboxes";
		
		AssertJUnit.assertEquals(checkboxTitle, expectedTitle);
		
	}
	
	
	
}
