package day18;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;

import day14.BrowserFactory;

public class UploadFiles {

	public static void main(String[] args) {
		Page page = BrowserFactory.initBrowser("chrome", false, false);

		page.navigate("https://the-internet.herokuapp.com/upload");
		
//		// Upload file
//		page.locator("input[type='file']").setInputFiles(Paths.get("src/test/resources/files/download.xlsx"));
//		System.out.println("File uploaded successfully!");

//		//Multiple
//		page.setInputFiles("[multiple='multiple']", new Path[] {
//				Paths.get("src/test/resources/files/download.xlsx"),
//				Paths.get("src/test/resources/files/download1.xlsx"),
//				Paths.get("src/test/resources/files/download.xlsx")});
		
		//File chooser
		FileChooser filechoose = page.waitForFileChooser(()->{
			page.click("[class='button']");
		});
		
		filechoose.setFiles(Paths.get("src/test/resources/files/download.xlsx"));
		
		}
}
