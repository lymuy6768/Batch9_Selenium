package Day9;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;

public class TestingWebDriver {
	
	@BeforeMethod
	public void setUp() {
		Driver.getDriver();
	}
	@Test
	public void test1() {
		Driver.getDriver().findElement(null);
	}
//	@After
//	public void afterMethod() {
//		Driver.tearDown();
	
}
