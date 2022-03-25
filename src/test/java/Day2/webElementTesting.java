package Day2;



import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webElementTesting {
	WebDriver driver;//create an object
	
	@BeforeMethod
	public void beforeMethod() {
	
		WebDriverManager.chromedriver().setup();	// webdriverManage come from libraries, declare driver
		
		//WebDriver driver =new Chromedriver(); //polyphism ,overridding 
		
		driver= new ChromeDriver();//invoke the browser , a blank browser open
		
		
		driver.get("http://demo.automationtesting.in/Index.html");//open url in browser
		
		driver.manage().window().maximize();
		
	}
	@Test
	public void inputEmailAddress() throws InterruptedException {
		
		driver.findElement(By.id("email")).sendKeys("abcyo@gmail.com");
//		Thread.sleep(1000);
	
		driver.findElement(By.id("enterimg")).click();
		driver.manage().window().maximize();
		//firstname
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("Lymuy");
//		Thread.sleep(1000);
		//last name
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("Heng");
//		Thread.sleep(1000);
		//address
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("1234 Connecticut Ave NW Washington DC 20008");
//		Thread.sleep(1000);
		//email address
		driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("abcyo@gmail.com");
//		Thread.sleep(1000);
		//phone number
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("2222345678");
//		Thread.sleep(1000);
		
		//gender
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]")).click();
//		Thread.sleep(1000);
		//hobbies
		driver.findElement(By.id("checkbox2")).click();
//		Thread.sleep(1000);
		//language
		//WebElement selectElement = driver.findElement(By.xpath("//*[@id=\"msdd\"]"));
		//Select selectObject = new Select(selectElement);
		//selectObject.selectByIndex(7);
// 		driver.findElement(By.id("msdd")).click();
		//Thread.sleep(3000);
		//English
//		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]/a")).click();
		driver.findElement(By.id("msdd")).click();
		
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]/a")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@id=\"section\"]/div/div")).click();
		
		//English
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]/a")).click();
		driver.findElement(By.xpath("//html")).click();
		
		
		driver.findElement(By.xpath("//html")).click();
		//skill
		Select skill= new Select(driver.findElement(By.id("Skills")));
		skill.selectByValue("QuickBooks");

		Select country= new Select(driver.findElement(By.id("country")));
		country.selectByValue("United States of America");
		
		driver.findElement(By.xpath("//html")).click();
		
		Select year= new Select(driver.findElement(By.id("yearbox")));
		year.selectByValue("1988");
		
		Select month = new Select(driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")));
		month.selectByValue("October");
		
		Select day = new Select(driver.findElement(By.id("daybox")));
		day.selectByValue("1");
		
		driver.findElement(By.xpath("//html")).click();

		driver.findElement(By.id("firstpassword")).sendKeys("A12345%");
		
		driver.findElement(By.id("secondpassword")).sendKeys("A12345%");
		
		//attached file
		WebElement attachedFile=driver.findElement(By.id("imagesrc"));
		attachedFile.sendKeys("/Users/lymheng/Desktop/TechCircle.png");
		System.out.println("upload passed");
		//submit
		driver.findElement(By.id("submitbtn")).click();
		
	}



}
