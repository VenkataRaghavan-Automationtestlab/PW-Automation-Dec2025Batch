package day1;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Arrays;
import com.microsoft.playwright.*;

public class BrowserFactory {

	private static Playwright playwright;
	private static Browser browser;

	public static Page initBrowser(String browserName, boolean headless, boolean fullScreen) {

		playwright = Playwright.create();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(1000);

		// Apply OS-level maximize ONLY for Chromium browsers
		if (fullScreen && (browserName.equalsIgnoreCase("chromium") || browserName.equalsIgnoreCase("chrome")
				|| browserName.equalsIgnoreCase("edge"))) {
			options.setArgs(Arrays.asList("--start-maximized"));
		}

		// 1️ Launch Browser
		switch (browserName.toLowerCase()) {

		case "chromium":
			browser = playwright.chromium().launch(options);
			break;

		case "chrome":
			options.setChannel("chrome");
			browser = playwright.chromium().launch(options);
			break;

		case "edge":
			options.setChannel("msedge");
			browser = playwright.chromium().launch(options);
			break;

		case "firefox":
			browser = playwright.firefox().launch(options);
			break;

		case "webkit":
			browser = playwright.webkit().launch(options);
			break;

		default:
			throw new IllegalArgumentException("Invalid browser name: " + browserName);
		}

		// 2️ Create Browser Context (cross-browser fullscreen)
		BrowserContext context;

		if (fullScreen && (browserName.equalsIgnoreCase("chromium") || browserName.equalsIgnoreCase("chrome")
				|| browserName.equalsIgnoreCase("edge"))) {
			context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		} else if (fullScreen && (browserName.equalsIgnoreCase("webkit") || browserName.equalsIgnoreCase("firefox"))){
			context = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width, (int)height));
		} else {
			context = browser.newContext(new Browser.NewContextOptions());
		}

		// 3️ Create Page
		return context.newPage();
	}

	public static void closeBrowser() {
		if (playwright != null) {
			playwright.close();
		}
	}
}
