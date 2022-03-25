package Day5;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Feb10TaskDress {
//	 		1. go to http://automationpractice.com/index.php
//		    2. click on DRESSES button
//		    3. add items on sale to cart and checkout
//		    4. continue to checkout until you see the 'authentication' page and verify it
	
		WebDriver driver;
		
		@BeforeMethod
		public void beforeMethod() {
			
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.get("http://automationpractice.com/");
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		@Test
		public void test1() {
			
			Actions action = new Actions (driver);
			WebDriverWait wait= new WebDriverWait(driver,10);
			
			//click on dress
			driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
			
			//add all items to a list
			List <WebElement> allItems= driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
			
			int numAllItems= allItems.size();
			
			for(int i=1;i<=numAllItems;i++) {
			
			WebElement item= driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+i+"]"));
		
			WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+i+"]/div/div[2]/div[2]/a[1]/span"));
			//continue shopping
			WebElement continueShopping= driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));
			
			String itemText= item.getText();
			//System.out.println(itemText);
			
			if(itemText.contains("%")) {
				action.moveToElement(item).build().perform();
				wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
				addToCartButton.click();
				wait.until(ExpectedConditions.elementToBeClickable(continueShopping));
				continueShopping.click();
			}
			}
			//go to cart
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
			
			//proceed checkout
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
			
			//verify Authentication
			String expectedAuthenticaion= "AUTHENTICATION";
			String actualAuthentication = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();
			AssertJUnit.assertEquals(expectedAuthenticaion, actualAuthentication);
			System.out.println("Passed");
		}			

}
