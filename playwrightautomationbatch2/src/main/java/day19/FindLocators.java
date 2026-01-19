package day19;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import day14.BrowserFactory;



public class FindLocators {
	
	public static void main(String[] args) {
		Page page = BrowserFactory.initBrowser("chrome", false, false);
		page.navigate("https://swautomationtester-dot.github.io/IshaDemoV1/index.html");
		page.fill("#username", "admin");
		page.fill("#password", "admin123");
		page.click("[type='submit']");
//		List<Locator> title = page.locator(".prod-title").all();
//		for (Locator titletext:title) {
//			System.out.println(titletext.textContent());
//		}
//		
		
		List<String> titletext = page.locator(".prod-title").allTextContents();
		System.out.println(titletext);
		
//		page.close();
	}

}
