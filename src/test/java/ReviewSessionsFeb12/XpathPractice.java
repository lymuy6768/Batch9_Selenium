package ReviewSessionsFeb12;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathPractice {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.usda.gov/");
		
	}
	@Test
	public void test() {
		
		driver.findElement(By.xpath("//*[@id=\"block-usda-main-menu\"]/ul/li[2]/button/span")).click();
		
		List <WebElement> allOptions = driver.findElements(By.xpath("//div[@id='side-nav-2']/ul/li"));
		
		for(WebElement e:allOptions) {
			String name = e.getText();
			System.out.println(name);
//		}System.out.println(allOptions.size());
		}
		}
}
