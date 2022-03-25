package day10;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class groupTests {
	
	@Test(groups= {"Smoke","Regression"})//run the term that in that group
	public void test1() {
		
	}
	@Test(groups= {"Smoke"})
	public void test2() {
		
	}
	@Test(groups= {"Smoke"})
	public void test3() {
		
	}
	@Test(groups= {"Regression","Integration"})
	public void test4() {
		
	}

}
