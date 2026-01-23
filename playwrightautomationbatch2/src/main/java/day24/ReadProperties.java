package day24;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Page;

import day14.BrowserFactory;

public class ReadProperties {
	
	public static void main(String[] args) throws IOException {
		
		
		Page page = BrowserFactory.initBrowser("chrome", false, true);
		// step1: setup the path of the properties file
		FileInputStream fis = new FileInputStream("./src/main/resources/properties/config.properties");
				
		// step2: Create object for Properties class
		Properties prop = new Properties(); 
				
		// step3: load the properties file
		prop.load(fis); 

//		page.navigate(prop.getProperty("URL"));
//		page.setDefaultTimeout(5000);
//		
//		// step4: to read the property
//		System.out.println(prop.getProperty("username")); 
//		System.out.println(prop.getProperty("password")); 
//		
//		page.fill("#username", prop.getProperty("username"));
//		page.fill("#password", prop.getProperty("password"));
//		page.click("text='Login'");
		
		String id = "test"; 
		// to save data into properties file
		FileOutputStream fos = new FileOutputStream("./src/main/resources/properties/config.properties");
		prop.setProperty("username", id);
		prop.store(fos, "Updating Password");

	}

}
