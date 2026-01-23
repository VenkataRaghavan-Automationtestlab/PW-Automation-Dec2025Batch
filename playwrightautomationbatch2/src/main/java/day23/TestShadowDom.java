package day23;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

import day14.BrowserFactory;

public class TestShadowDom {
public static void main(String[] args) {
	Page page = BrowserFactory.initBrowser("chrome", false, true);
	page.navigate("https://vrqaacademy.co.in/labs/shadow.html");
	page.setDefaultTimeout(5000);
	
	FrameLocator frame = page.frameLocator("#shadowIframe");

	frame.locator("[id='user']").last().fill("Venkat");
	frame.locator("[id='btn']").last().click();
	
}
}
