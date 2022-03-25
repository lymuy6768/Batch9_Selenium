package Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class OpenBrowserTest {

	public static void main(String[] args) {
	
		WebDriver driver;//create an object
		
		
		WebDriverManager.chromedriver().setup();	
		
		driver= new ChromeDriver();//invoke the browser , a blank browser open
		
		
		driver.get("https://www.techcircleschool.com");//open url in browser
		
		
	}

}
