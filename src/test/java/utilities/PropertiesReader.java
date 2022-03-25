package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {
	
	private static Properties configFile;//static so all the object in this class can use
	
	static {//if something happen,it can throw exception
		try {
			
			String filePath= "src/test/resources/dataFolder/config.properties";
			
			FileInputStream input= new FileInputStream(filePath);//open the path for file
			
			configFile = new Properties();//open and load key value pair, and put it to the class configFile
			configFile.load(input);
			input.close();
			
	
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
		public static String getProperty(String keyName) {
			return configFile.getProperty(keyName);
			
		}
		
		
		
		
		
	
	
}
