package day23;

import com.microsoft.playwright.Page;

import day14.BrowserFactory;

public class TestIframes {
	
	public static void main(String[] args) {
		Page page = BrowserFactory.initBrowser("chrome", false, true);
		page.navigate("https://www.leafground.com/frame.xhtml");
		page.setDefaultTimeout(5000);
		
		page.frameLocator("[src='default.xhtml']").locator("[id='Click']").first().click();
		
		page.frameLocator("[src='page.xhtml']").frameLocator("#frame2").locator("[onclick='change()']").last().click();
	}

}
