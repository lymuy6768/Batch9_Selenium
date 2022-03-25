package Day12;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.Driver;

public class myAccountLogin {
	
	
	@BeforeMethod
	public void beforeTest() {
		Driver.getDriver();
		
	}
	
	@Test
	public void loginWithValidUserNamePassword() {
	
		Driver.getDriver().findElement(By.xpath("//*[@id=\"menu-item-50\"]")).click();
		
		
/*		1) Open the browser
	2) Enter the URL “http://practice.automationtesting.in/”
	3) Click on My Account Menu
	4) Enter registered username in username textbox
	5) Enter password in password textbox
	6) Click on login button
	7) User must successfully login to the web page*/
		
	}

}
