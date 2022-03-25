package Day2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class openAndVerifyTitle {
	WebDriver driver;//create an object
	
	@BeforeMethod
	public void beforeTest() {
		
		WebDriverManager.chromedriver().setup();	
		driver= new ChromeDriver();//invoke the browser , a blank browser open
		driver.get("https://www.youtube.com/");//open url in browser
		
		driver.manage().window().maximize();
			
	}
	@AfterMethod
	public void afterTest() {
		driver.close();
	}
	@Test(enabled = false)
	
	public void verifyTitle() {
		
		String actualUrl=driver.getCurrentUrl();
        String actualPageTitle=driver.getTitle();

        String expectedUrl = "https://www.youtube.com/";
        String expectedPageTitle = "YouTube";

        if (expectedUrl.equalsIgnoreCase(actualUrl)) {
            System.out.println("Url matched and Passed");
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
	@Test(enabled = false)
	
	public void verifyUrl() {

			String actualUrl= driver.getCurrentUrl();
			String expectedUrl="https://www.youtube.com/";
			
			if(expectedUrl.equalsIgnoreCase(actualUrl)) {
				System.out.println("URL matched and passed");
				
			}else {
				System.out.println("FAILED");
				System.out.println("Expected to see-->"+ expectedUrl);
				System.out.println("The Driver got -->"+ actualUrl);
				
			}
	}
	@Test
	public void pageSourcePrint() {
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		
		driver.navigate().to("https://www.techcircleschool.com");
		driver.navigate().back();
	}
	
	
	
}
