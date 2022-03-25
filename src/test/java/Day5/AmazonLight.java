package Day5;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonLight {
//	go to amazon.com
//	type in search "iphone"
//	click on the first iphone the price over $1400, if the first page not found, click go to the next page until it found
//	print the name of the product
//	then verify the price that actually over $1400
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	}
	@Test
	public void test1() {
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
		
		/*click next page
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[29]/div/div/span/a[1]")).click();
		
		//select over 1400 phone on 2nd page
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[19]/div/div/div/div/div/div[1]/div/div[2]/div/span/a/div/img")).click();*/
		
		List <WebElement> searchResults = driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div"));
		
		for(int i=8;i<searchResults.size();i++);
			WebElement eachPrice = driver.findElement(By.xpath("//*[@id=\\\"search\\\"]/div[1]/div[1]/div/span[3]/div[2]/div[\" + i\n"
					+ "                            + \"]/div/div/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div/a/span[1]/span[2]/span[2]"));
			System.out.println(eachPrice.getText());
			if(Integer.parseInt(eachPrice.getText())<=150){
						eachPrice.click();
		
			}	
	}
	
	
	
	
}
