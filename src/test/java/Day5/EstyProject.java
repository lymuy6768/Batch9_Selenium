package Day5;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EstyProject {
//	go to etsy.com
//	type in search "Light"
//	click on the first product the price between $30-$50, if the first page not found, click go to the next page until it found
//	get the name of the product
//	then verify the price
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.etsy.com/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	@Test
	public void searchForLight() {
		
		driver.findElement(By.id("global-enhancements-search-query")).sendKeys("Light");
		driver.findElement(By.xpath("//*[@id=\"gnav-search\"]/div/div[1]/button")).click();
		
		//click on the first product the price between $30-$50,
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[4]/div[5]/div[3]/div[9]/div/div/div[1]/ul/li[5]/div/div/a[1]/div[1]/div/div/div/div/div/img")).click();
		String light=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[4]/div[5]/div[3]/div[9]/div/div/div[1]/ul/li[5]/div/div/a[1]/div[1]/div/div/div/div/div/img")).getText();
		System.out.println(light);
	
	}
	

}
