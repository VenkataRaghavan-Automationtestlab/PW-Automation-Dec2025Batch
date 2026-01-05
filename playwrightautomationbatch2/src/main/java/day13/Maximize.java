package day13;

import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Maximize {
	
	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
				.setSlowMo(1000).setArgs(Arrays.asList("--start-maximized")));
		BrowserContext context1 = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = context1.newPage();
		page.navigate("https://www.saucedemo.com/");
		page.fill("#user-name", "standard_user");
		page.fill("#password", "secret_sauce");
//		page.waitForTimeout(3000);
		page.click("#login-button");
	}

}
