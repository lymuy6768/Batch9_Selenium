package day11;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderTesting {
	
	@Test(dataProvider="nameList")//pick up the name from data provider below
	public void myTest(String myName) {
		System.out.println("My name is  "+ myName);
	}
	@Test(dataProvider="ageList",enabled=true)
	public void ageTest(Integer age) {
		System.out.println("My age is  "+ age);
	}
	
	@DataProvider(name="nameList")
	public Object[][] nameMethod(){
		return new Object[][] {{"Shafkat"},{"Irfan"},{"Techcircle"}};
		
	}
	@DataProvider(name="ageList")
	public Integer[][] ageMethod(){
		return new Integer[][] {{33},{44}};
		
	}
}
