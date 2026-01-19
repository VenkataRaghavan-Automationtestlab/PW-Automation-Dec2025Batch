package day19;

import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingAuth {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
				.setArgs(Arrays.asList("--start-maximized")).setSlowMo(1000));
		String password = "admin";
		BrowserContext context = browser
				.newContext(new Browser.NewContextOptions().setViewportSize(null).setHttpCredentials("admin", password));
		Page page = context.newPage();
		page.navigate("https://the-internet.herokuapp.com/basic_auth");

	}

}
