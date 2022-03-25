package utilities;

import pages.CommonPage;

public class PageInitializer {

	public static CommonPage cp;//public static 
	
	public static void initialize() {
		cp=new CommonPage();//extends this class to test case to use this class object in test case
	}
}
