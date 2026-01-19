package day15;

import java.nio.file.Paths;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;

import day14.BrowserFactory;

public class Upload {
	
	public static void main(String[] args) {
		Page page = BrowserFactory.initBrowser("chrome", false, false);
		// Example: imagine this is your app
        page.navigate("https://the-internet.herokuapp.com/upload");

        // ⚡ REAL TIME PATTERN
        FileChooser fileChooser = page.waitForFileChooser(() -> {
            // This click opens OS file dialog
            page.click("#file-upload");
        });

        // Select file from system (bypasses OS dialog)
        fileChooser.setFiles(Paths.get("C:\\Users\\Venkataraghavan\\git\\repository2\\playwrightautomationbatch2\\src\\test\\resources\\files\\Picture1.jpg"));

        // Submit upload
        page.click("#file-submit");

        // Verification
        String uploaded = page.locator("#uploaded-files").innerText();
        System.out.println("Uploaded File: " + uploaded);
	}

}
