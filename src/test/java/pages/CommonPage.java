package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class CommonPage {
	
	public CommonPage() {//for those that can find anywhere even we click other tap,anything appear more than one time in the page can put here, homepage
		
	PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="//li[@id='menu-item-50']")
	public WebElement myAccountTab;
	
}
