package Day7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlesTest {
	
WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {

	
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://phptravels.com/demo/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@Test
	public void loginAgentFrontEndPage() {
		
		String email = "agent@phptravels.com";
		String passWord ="demoagent";
		
		//should open up the front end page
		driver.findElement(By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[3]/div/div/div[2]/div/div/div[1]/div/a")).click();

		
		
		//switch my selenium t new window
		
		System.out.println("Before switchcing-- title is "+driver.getTitle());
		
		Set <String> ids= driver.getWindowHandles();//before open child page , need to do this
		
		Iterator<String> it = ids.iterator();
		
		String parentID = it.next();
		String childID = it.next();
		//print what main window look like
		String mainWindow= driver.getWindowHandle();
		System.out.println("Main window handle is "+ mainWindow);
		
		driver.switchTo().window(childID);
		System.out.println("After switching to child window"+ driver.getTitle());
	
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input")).sendKeys(passWord);
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button")).click();
		
		//click ok to cookies
		driver.findElement(By.xpath("//*[@id=\"cookie_stop\"]")).click();
		//driver.switchTo().window(parentID);
		
		//add funds
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[3]/ul/li[3]/a")).click();
		
		//select pay with bank transfer
		driver.findElement(By.xpath("//*[@id=\"myTab\"]/div[1]/div")).click();
		
		//pay now
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div/div[2]/div/button")).click();	
		
		//verify
		String expectedResult= "Pay With Bank Transfer USD 50.00";
		String actualResult = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/small")).getText();
		System.out.println(actualResult);
		AssertJUnit.assertEquals(expectedResult, actualResult);
		
		//back to invoice
		WebElement backToInvoice=driver.findElement(By.xpath("/html/body/div/div[2]/div[2]"));
		AssertJUnit.assertTrue(backToInvoice.isDisplayed());
		backToInvoice.click();
		
		//click yes
		driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/a")).click();
		
		//log out
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[3]/ul/li[5]/a")).click();
		
		driver.switchTo().window(parentID);
	}
}
