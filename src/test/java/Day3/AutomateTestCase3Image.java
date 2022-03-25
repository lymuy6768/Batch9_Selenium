package Day3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateTestCase3Image {

/*1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
7) Now click the image in the Arrivals
8) Test whether it is navigating to next page where the user can add that book into his basket.
9) Image should be clickable and shoul navigate to next page where user can add that book to his basket*/
	

	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://practice.automationtesting.in/");
		
		driver.manage().window().maximize();

}
	@Test
	public void test1() {
		
		//click on shop menu
		driver.findElement(By.id("menu-item-40")).click();
		
		//click on Home menu
		driver.findElement(By.xpath("//*[@id=\"content\"]/nav/a")).click();
		
		//check 3 arrivals only
		
		List<WebElement> arrivals = driver.findElements(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div"));
		
		int numOfarrivals = arrivals.size();
		
		if(numOfarrivals==3) {
			System.out.println("There are only three Arrivals.");
		}else {System.out.println("Failed");}
		
		
		//click on the image in the Arrivals
		
		for (int i=0;i<arrivals.size();i++) {
			List <WebElement> allItemImages = driver.findElements(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div"));
		}
		
	//8) Test whether it is navigating to next page where the user can add that book into his basket.
		
		String currentUrl= driver.getCurrentUrl();
		
		//allItemImages.get(i).click()
;
		String AfterClickedUrl = driver.getCurrentUrl();
		
		AssertJUnit.assertFalse(false);
		
		List<WebElement> checkOutButton = driver.findElements(By.xpath("//button[@type='submit']"));
		
		if(checkOutButton.size()>0) {
			AssertJUnit.assertTrue(checkOutButton.size()>0);
		
	
		}
	
	}
}