package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReaderManager {  //1.private method  2.public method 3.main method (validation)
	
	private static Properties property;
	private static void setUpProperty() {
		File file = new File("C:\\Users\\ajith\\eclipse-workspace\\MavenBlazeProject\\src\\main\\resources\\TestData.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			property = new Properties();
			property.load(fis);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	public static String getProperty(String key) {
		setUpProperty();
		String value = property.getProperty(key);
	//	System.out.println(value);
		return value;
	}
	
//	public static void main(String[] args) {
//		
//		getProperty("blazeUrl");
//		
//	}

}
