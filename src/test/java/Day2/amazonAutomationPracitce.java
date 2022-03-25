package Day2;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazonAutomationPracitce {
	WebDriver driver;//create an object
	@BeforeMethod
	public void beforeMethod() {
	
		WebDriverManager.chromedriver().setup();	// webdriverManage come from libraries, declare driver
		
		//WebDriver driver =new Chromedriver(); //polyphism ,overridding 
		
		driver= new ChromeDriver();//invoke the browser , a blank browser open
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();

}
//	@After
//	public void afterTest() {
//		driver.close();
//	}
}