package day15;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import day14.BrowserFactory;

public class RoleLocators {
	
	public static void main(String[] args) {
		Page page = BrowserFactory.initBrowser("chrome", false, false);
		page.navigate("https://rahulshettyacademy.com/upload-download-test/");

	    // Upload file
	    page.locator("input[type='file']").setInputFiles(Paths.get("src/test/resources/files/download.xlsx"));
	    System.out.println("File uploaded successfully!");

	    Download download = page.waitForDownload(() -> {
	        page.locator("text=Download").click();
	    });

	    // Save file
	    Path downloadedFile = Paths.get("downloads", download.suggestedFilename());
	    download.saveAs(downloadedFile);
	    download.saveAs(Paths.get("YOUR/FOLDER/PATH/filename.ext"));

	    System.out.println("Downloaded file to: " + downloadedFile.toAbsolutePath());
	}

}
