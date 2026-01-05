package day13;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestContext {
	
	public static void main(String[] args) {
		try (Playwright pw = Playwright.create()) {
			Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
			Browser browser1 = pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
			
			BrowserContext context1 = browser.newContext();
			Page pageA = context1.newPage();

			pageA.navigate("https://www.saucedemo.com/");
			pageA.fill("#user-name", "standard_user");
			pageA.fill("#password", "secret_sauce");
			pageA.click("#login-button");
			
			BrowserContext context2 = browser1.newContext();
			Page pageB = context2.newPage();

			pageB.navigate("https://www.saucedemo.com/");
			pageB.fill("#user-name", "locked_out_user");
			pageB.fill("#password", "secret_sauce");
			pageB.click("#login-button");
		}
	}

}
