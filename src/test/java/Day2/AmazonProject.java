package Day2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonProject {

	/*
	 * 1. Go to Amazon 2. Send "any key" 3. click search 4. select one of the item
	 * 5. add it to cart 6. validate the item in the cart 7. remove the item 8.
	 * validate the cart is empty 9. navigate to youtube 10. validate the title is
	 * youtube 11. search video 12. play the video.
	 */

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
	}

	@Test
	public void searchItem() throws InterruptedException {

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java books for beginner");
		Thread.sleep(1000);

		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/div/div/div/div/div[1]/div/div[2]/div/span/a/div/img"))
				.click();
		Thread.sleep(3000);

		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(1000);
		// validate cart
		driver.findElement(By.xpath("//*[@id=\"nav-cart-text-container\"]/span[2]")).click();
		Thread.sleep(1000);

		// remove item
		WebElement remove = driver.findElement(By.xpath("//input[@value='Delete']"));
		remove.click();
		Thread.sleep(1000);

		// validate the cart is empty
		driver.findElement(By.xpath("//*[@id=\"nav-cart-text-container\"]/span[2]")).click();
		Thread.sleep(1000);

		// navigate to youtube
		driver.navigate().to("https://www.youtube.com/");
		Thread.sleep(1000);

		// validate the title is YouTube
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "YouTube";

		if (actualPageTitle.equalsIgnoreCase(expectedPageTitle)) {
			System.out.println("Title matched and passed");
		} else {
			System.out.println("Title mismatched and failed");
		}

		// key in name for video
		driver.findElement(By.name("search_query")).sendKeys("itsy spider song");
		Thread.sleep(1000);

		// search video
		driver.findElement(By.xpath("//*[@id=\"search-icon-legacy\"]/yt-icon")).click();
		Thread.sleep(1000);

		// select the video
		driver.findElement(By.linkText("ITSY BITSY SPIDER - Song for Children")).click();
	
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		
		 Thread.sleep(100000);
		 
		 driver.close();
	}

}
