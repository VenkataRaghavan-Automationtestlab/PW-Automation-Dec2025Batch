package day22;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import day14.BrowserFactory;

public class ScreenshotTest {
	
	public static void main(String[] args) {
		
		Page page = BrowserFactory.initBrowser("chrome", false, true);
		page.navigate("https://vrqaacademy.co.in/labs/uploads.html");
		
		takeScreenshot(page, "Uploads_Page", true);
		takeScreenshot(page, "Uploads_Page_ViewPort", false);
		takeScreenshotElement(page, "#chooseBtn", "Uploads_Page_Element");
	}
	
	public static void takeScreenshot(Page page, String name, boolean fullscreen) {
	    String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
	    
	    Path path = Paths.get("screenshots/" + name + "_" + timestamp + ".png");
	    page.screenshot(new Page.ScreenshotOptions().setPath(path).setFullPage(fullscreen));
	}
	
	public static void takeScreenshotElement(Page page, String locator, String name) {
	    String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
	    
	    Path path = Paths.get("screenshots/" + name + "_" + timestamp + ".png");
	    Locator element = page.locator(locator).first();
	    element.screenshot(new Locator.ScreenshotOptions().setPath(path));
	}

}
