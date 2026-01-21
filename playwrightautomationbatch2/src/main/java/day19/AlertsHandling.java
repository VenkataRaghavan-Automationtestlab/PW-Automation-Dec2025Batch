package day19;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;

import day14.BrowserFactory;

public class AlertsHandling {
	
	
	public static void main(String[] args) {
		Page page = BrowserFactory.initBrowser("chrome", false, false);
		page.navigate("https://vrqaacademy.co.in/labs/double-click.html");

		page.locator("text=Double Click Me").dblclick();
	}

}
