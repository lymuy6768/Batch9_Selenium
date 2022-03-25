package Day6;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class actionClassDragandDrop {
	
WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
//		1) Open the browser
//		2) Enter the URL “http://the-internet.herokuapp.com//”
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}
	@Test
	public void dragAndDrop() {
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[10]/a")).click();
		
		WebElement source = driver.findElement(By.id("column-a"));
		
		WebElement target = driver.findElement(By.id("column-b"));
		
		Actions action = new Actions(driver);
		
		//action.clickAndHold(source).moveToElement(target).release().build().perform();
		
		action.dragAndDrop(source, target).build().perform();
	}
}