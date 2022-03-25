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

	public class windowSwitch {
		WebDriver driver;
		String email = "agent@phptravels.com";
		String password = "demoagent";

		@BeforeMethod
		public void beforeTest() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://phptravels.com/demo");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@Test
		public void bankTranserTest() {
			//click on Agent log in button
			driver.findElement(By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[3]/div/div/div[2]/div/div/div[1]/div/a")).click();
			//get the id for the new windows
			Set<String> id = driver.getWindowHandles();
			Iterator<String> itr = id.iterator();
			String parentWindows = itr.next();
			String childWindows = itr.next();
			//switch to new windows
			driver.switchTo().window(childWindows);
			//clicks ok on the cookie popup
	        driver.findElement(By.id("cookie_stop")).click();	
			//enter email
			driver.findElement(By.xpath("//*[@id='fadein']/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input")).sendKeys(email);
			//enter password
			driver.findElement(By.xpath("//*[@id='fadein']/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input")).sendKeys(password);
	        driver.findElement(By.xpath("//*[@id='fadein']/div[1]/div/div[2]/div[2]/div/form/div[3]/button")).click(); 
	        //click add funds
	        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[3]/ul/li[3]/a")).click();
	        //check in bank transfer
	        driver.findElement(By.id("gateway_bank-transfer")).click();
	        //click play now
	        driver.findElement(By.xpath("//*[@id='fadein']/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div/div[2]/div/button")).click();
	        //verify if the Back to invoices visible
	        WebElement backToInvoicesButton = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]"));
	        AssertJUnit.assertTrue(backToInvoicesButton.isDisplayed());
	        backToInvoicesButton.click();
	        //click yes
	        driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/a")).click();
		}
	

}
