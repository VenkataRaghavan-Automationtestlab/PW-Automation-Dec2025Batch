package day14;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Arrays;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserFactory {

	private static Playwright playwright;
	private static Browser browser;

	public static Page initBrowser(String browserName, boolean headless, boolean fullScreen) {

		playwright = Playwright.create();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

		BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(headless);

		if (fullScreen && (browserName.equalsIgnoreCase("chromium") || browserName.equalsIgnoreCase("chrome")
				|| browserName.equalsIgnoreCase("edge"))) {

			options.setArgs(Arrays.asList("--start-maximized"));

		}

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
			throw new IllegalArgumentException("Invalid BrowserName: " + browserName);
		}

		BrowserContext context;

		if (fullScreen && (browserName.equalsIgnoreCase("chromium") || browserName.equalsIgnoreCase("chrome")
				|| browserName.equalsIgnoreCase("edge"))) {
			context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

		} else if (fullScreen && (browserName.equalsIgnoreCase("firefox") || browserName.equalsIgnoreCase("webkit"))) {
			context = browser.newContext(new Browser.NewContextOptions().setViewportSize((int) width, (int) height));
		} else {
			context = browser.newContext(new Browser.NewContextOptions());
		}
		
		return context.newPage();
	}

	public static void closeBrowser() {
		if(playwright != null) {
			playwright.close();
		}
	}
}
