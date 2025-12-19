package day1.demo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowser {
	
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
		
//		browser.close();
//		pw.close();
	}
}
