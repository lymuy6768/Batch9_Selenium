package day10;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class orderOfTests {
	
	@Test(priority=1)//method//attribute priority to run the test
	public void testSelenium() {
		System.out.println("selenium");
	}
	@Test(priority=2)//method
	public void testJava() {
		System.out.println("Java");}
	 @Test(priority=3)//method
		public void testAPI() {
			System.out.println("API");}
	 @Test(priority=4,enabled=false)//method//enable = false is skip running
		public void testSQL() {
			System.out.println("SQL");}
	 
	    @BeforeMethod
	    public void beforeMethod() {
	        System.out.println("beforeMethod");

	    }
	    
	    @AfterMethod
	    public void afterMethod() {
	        System.out.println("afterMethod");

	    }
	    

}
