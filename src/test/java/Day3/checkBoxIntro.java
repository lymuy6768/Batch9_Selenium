package Day3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkBoxIntro {
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
//		1) Open the browser
//		2) Enter the URL “http://the-internet.herokuapp.com//”
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void test1() {
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a")).click();
		
		WebElement firstCheckboxElement = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
		
		WebElement secondCheckboxElement = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
		
		Boolean firstCheckbox = firstCheckboxElement.isSelected();
		Boolean secondCheckbox = secondCheckboxElement.isSelected();
//		
//		if(firstCheckbox) {
//			System.out.println("checkbox is already checked");;
//		}else {
//			secondCheckboxElement.click();
//		}
//		
//		if(secondCheckbox) {
//			System.out.println("Checkbox is already selected.");
//		}else {
//			secondCheckboxElement.click();
//		}
//		
		if(!firstCheckbox) {
			firstCheckboxElement.click();
		}else if(!secondCheckbox) {
			secondCheckboxElement.click();
		}
//		
		
		
	}

}
