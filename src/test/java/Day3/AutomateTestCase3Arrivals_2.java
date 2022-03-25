package Day3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateTestCase3Arrivals_2 {
/*	1) Open the browser
	2) Enter the URL “http://practice.automationtesting.in/”
	3) Click on Shop Menu
	4) Now click on Home menu button
	5) Test whether the Home page has Three Arrivals only
	6) The Home page must contains only three Arrivals */
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforemethod(){
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://practice.automationtesting.in/");
		
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void test3Arrivals() {
		//click on shop
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		
		//click on home menu
		driver.findElement(By.xpath("//*[@id=\"content\"]/nav/a")).click();
		
		//check 3 sliders or not
		
		List <WebElement> arrivals= driver.findElements(By.xpath("//*[@id=\"themify_builder_content-22\"]/div"));
		
		int numOfSliders = arrivals.size();
		
		System.out.println(numOfSliders);
		
		if(numOfSliders ==3) {
			System.out.println("There are only 3 arrival sliders.");
		}else {
			System.out.println("Total of arrival sliders are not 3.");
			
		}
		
	}
	//@Ignore
//	@After
	//public void afterTest() {
	//	driver.close();
	//}
		
		
	
}
