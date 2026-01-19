package day18;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;

import day14.BrowserFactory;

public class DownloadFile {
	
	
	public static void main(String[] args) {
		
		
		Page page = BrowserFactory.initBrowser("chrome", false, false);
//		page.navigate("https://rahulshettyacademy.com/upload-download-test/");

//		Download download = page.waitForDownload(() -> {
//		page.locator("text=Download").click();
//		});
//		
//		// Save file
//		Path downloadedFile = Paths.get("downloads", download.suggestedFilename());
//		download.saveAs(downloadedFile);
//
////		System.out.println("Downloaded file to: " + downloadedFile.toAbsolutePath());
		
		Download download = page.waitForDownload(() -> { page.evaluate("window.open('https://the-internet.herokuapp.com/download/test.txt')"); }); 
		download.saveAs(Path.of("src/test/resources/file.pdf"));

	}

}
