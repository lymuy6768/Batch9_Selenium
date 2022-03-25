package utilities;

import org.apache.log4j.chainsaw.Main;

public class Constants {//nothing is changed
	
	public static final int IMPLICIT_WAIT_TIME=10;
	
	public static final String CONFIGURATION_FILEPATH=System.getProperty("user.dir")+"/src/test/resources/dataFolder/config.properties";
//if we dont put System.getProperty("user.dir"), when we clone the project, the computer may not know where is the file path
	
	public static void main(String[] args) {
		System.out.println("user.dir");
	}
}
