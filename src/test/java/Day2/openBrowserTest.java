package Day2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class openBrowserTest {
	
	    WebDriver driver;
	    @BeforeMethod
		public void beforeTest() {

	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://www.youtube.com/");
	    }

	    @Test
	    public void verifyTitle() {
	        String actualUrl=driver.getCurrentUrl();
	        String actualPageTitle=driver.getTitle();

	        String expectedUrl = "https://www.youtube.com/";
	        String expectedPageTitle = "YouTube";

	        if (expectedUrl.equalsIgnoreCase(actualUrl)) {
	            System.out.println("Title matched and Passed");
	        } else {
	            System.out.println("Failed");
	            System.out.println("Expected to see--> " + expectedUrl);
	            System.out.println("The Driver got --> " + actualUrl);
	            }

	        if (expectedPageTitle.equalsIgnoreCase(actualPageTitle)) {
	            System.out.println("Title matched and Passed");
	        } else {
	            System.out.println("Failed");
	            System.out.println("Expected to see--> " + expectedPageTitle);
	            System.out.println("The Driver got --> " + actualPageTitle);
	        }

	    }

	    public void verifyURL() {
	        String actualUrl=driver.getCurrentUrl();
	        String expectedUrl = "https://www.youtube.com/";
	        if (expectedUrl.equalsIgnoreCase(actualUrl)) {
	            System.out.println("Title matched and Passed");
	        } else {
	            System.out.println("Failed");
	            System.out.println("Expected to see--> " + expectedUrl);
	            System.out.println("The Driver got --> " + actualUrl);
	        }
	    
	    }

	

}
