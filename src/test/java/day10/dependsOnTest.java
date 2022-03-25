package day10;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class dependsOnTest {

	 @Test(dependsOnMethods= {"Smoke"})
		public void signIn() {
			System.out.println("This will execute depending on the success of open browser");
			}
	 
	 @Test(dependsOnGroups= {"Smoke"},groups= {"Smoke"})//only all test in group "smoke" is successful passed,then line 16 will exececute
		public void openBrowser() {
			System.out.println("This will execute first(open Browser)");//it is before assertion , so it is still print out
			//Assert.assertTrue(false);//when this fail , the next step is skipped
			}
}
