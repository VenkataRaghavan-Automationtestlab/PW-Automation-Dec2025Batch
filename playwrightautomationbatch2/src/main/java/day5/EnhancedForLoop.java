package day5;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class EnhancedForLoop {

	public static void main(String[] args) {
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://swautomationtester-dot.github.io/IshaDemoSite/index.html");	
		
		String title = page.title();
		System.out.println(title);
		
		page.fill("#username", "admin");
		page.fill("#password", "admin123");
		page.click("[type='submit']");
		
		List<String> texts = page.locator("//*[@class='prod-card']//*[@class='prod-title']").allTextContents();
		for (String t : texts) {
		 System.out.println("Item: " + t);
		}
	}
}
