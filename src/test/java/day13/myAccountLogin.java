package day13;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import utilities.Driver;
import utilities.PropertiesReader;

//@Listeners(ListernersTestNG.class)
public class myAccountLogin {

	@BeforeMethod
	public void beforeTest() {
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
		Driver.getDriver();
	}

	@Test(enabled=true)
	public void LoginWithValidUsernamePassword() {

//	3) Click on My Account Menu
		Driver.getDriver().findElement(By.xpath("//*[@id=\"menu-item-50\"]")).click();
//	4) Enter registered username in username textbox	
//	5) Enter password in password textbox
		Driver.getDriver().findElement(By.id("username")).sendKeys(PropertiesReader.getProperty("automationUsername"));
		Driver.getDriver().findElement(By.id("password")).sendKeys(PropertiesReader.getProperty("automationPassword"));

//	6) Click on login button
		Driver.getDriver().findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();

//	7) User must successfully login to the web page	
		Driver.getDriver().findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).click();

	}
	
	
	@Test
	public void LoginWithInvalidUsernameInvalidPassword() {

//		3) Click on My Account Menu
			Driver.getDriver().findElement(By.xpath("//*[@id=\"menu-item-50\"]")).click();
//		4) Enter registered username in username textbox	
//		5) Enter password in password textbox
			Driver.getDriver().findElement(By.id("username")).sendKeys(PropertiesReader.getProperty("invalidUserName"));
			Driver.getDriver().findElement(By.id("password")).sendKeys(PropertiesReader.getProperty("invalidPassword"));

//		6) Click on login button
			Driver.getDriver().findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();

//		7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
		String actualErrorValue =	Driver.getDriver().findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
		//System.out.println(error);
		
		AssertJUnit.assertEquals(PropertiesReader.getProperty("errorUserCouldNotbeFound"), actualErrorValue);
		
		}
	
	
	@Test
	public void LoginWithValidUsernameEmptyPassword() {

//		3) Click on My Account Menu
			Driver.getDriver().findElement(By.xpath("//*[@id=\"menu-item-50\"]")).click();
//		4) Enter registered username in username textbox	
//		5) Enter password in password textbox
			Driver.getDriver().findElement(By.id("username")).sendKeys(PropertiesReader.getProperty("automationUsername"));
			Driver.getDriver().findElement(By.id("password")).sendKeys("");

//		6) Click on login button
			Driver.getDriver().findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();

//			7) Proper error must be displayed(ie Invalid password) and prompt to enter login again

			String errorPassword = Driver.getDriver().findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();

			AssertJUnit.assertEquals(PropertiesReader.getProperty("errorInvalidPassword"), errorPassword);
			
			
			
		}
	
	
	
	

}
