package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {
	
	
private static Properties property;
	
	static {
		
		try {
			File file = new File("./resources/testData/env_variables.properties");
			FileInputStream input = new FileInputStream(file);
			property = new Properties();
			property.load(input);
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getProperty(String key) {
		return property.getProperty(key);
	}

}
