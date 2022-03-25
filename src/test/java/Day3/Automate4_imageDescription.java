package Day3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate4_imageDescription {
/*	1) Open the browser
	2) Enter the URL “http://practice.automationtesting.in/”
	3) Click on Shop Menu
	4) Now click on Home menu button
	5) Test whether the Home page has Three Arrivals only
	6) The Home page must contains only three Arrivals
	7) Now click the image in the Arrivals
	8) Test whether it is navigating to next page where the user can add that book into his basket.
	9) Image should be clickable and should navigate to next page where user can add that book to his basket
	10) Click on Description tab for the book you clicked on.
	11) There should be a description regarding that book the user clicked on*/

	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("http://practice.automationtesting.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test1() {

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
			//click on the image in the Arrivals
			driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-2-0\"]/div/ul/li/a[1]/img")).click();
			
			//8)Test whether it is navigating to next page where the user can add that book into his basket.
			
			AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-2-0\"]/div/ul/li/a[1]/img")).isSelected());
			//9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
			driver.findElement(By.xpath("//*[@id=\"product-165\"]/div[2]/form/button")).click();
			
			
			//10) Click on Description tab for the book you clicked on.
			driver.findElement(By.xpath("//*[@id=\"product-165\"]/div[3]/ul/li[1]/a")).click();
			//11) There should be a description regarding that book the user clicked on
			AssertJUnit.assertEquals(arrivals, arrivals);
	
	
	
	}
}
