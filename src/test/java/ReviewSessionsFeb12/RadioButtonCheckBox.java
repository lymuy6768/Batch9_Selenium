package ReviewSessionsFeb12;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonCheckBox {
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/checkboxradio/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void click() {
		
		//use either one driver.switchTo().parentFrame
		//driver.switchTo().default content
		
		//frame inside a frame, integration from another website, switch to that page, then switch back
		
		//driver.findElement(By.xpath("//iframe")).getSize();
		driver.switchTo().frame(0);
	//	driver.findElement(By.xpath("/html/body/div/fieldset[1]/label[2]")).click();
		
		List <WebElement> checkboxradioSections= driver.findElements(By.xpath("/html/body/div/fieldset"));
		
		for(WebElement eachSection:checkboxradioSections){
			String eachSec = eachSection.getText();
			System.out.println("-------------\n"+ eachSec+"\n------------------");
			
			if (eachSec.contains("Location")) {
					List<WebElement> LocationRadioButtons = driver.findElements(By.xpath("/html/body/div/fieldset[1]/label"));
					for(WebElement eachLocationRadioButton: LocationRadioButtons){
						if(eachLocationRadioButton.getText().contains("Paris")) {
							eachLocationRadioButton.click();
						}
					}	
			}
			
			if(eachSec.contains("Hotel")) {
				List <WebElement> HetelRadioCheckbox = driver.findElements(By.xpath("/html/body/div/fieldset[2]/label"));
				for (WebElement eachHotelRating : HetelRadioCheckbox) {
					if(eachHotelRating.getText().contains("2 Star")) {
						eachHotelRating.click();
					}
					if(eachHotelRating.getText().contains("3 Star")) {
						eachHotelRating.click();
						
					}
					
				}
			}
			
			if(eachSec.contains("Bed")) {
				List <WebElement> bedTypeCheckbox = driver.findElements(By.xpath("/html/body/div/fieldset[3]/label"));
				for(WebElement eachBedType : bedTypeCheckbox) {
					if(eachBedType.getText().contains("2 Double")) {
						eachBedType.click();
					}
					if(eachBedType.getText().contains("1 Queen")) {
						eachBedType.click();
					}
					if(eachBedType.getText().contains("1 King")) {
						eachBedType.click();
					}
					}
			}
	
			driver.switchTo().parentFrame();
			//driver.switchTo().defaultContent();
			
			driver.findElement(By.xpath("//*[@id=\"menu-top\"]/li[1]/a")).click();
		}
		
		
		
	
	
	}
}
