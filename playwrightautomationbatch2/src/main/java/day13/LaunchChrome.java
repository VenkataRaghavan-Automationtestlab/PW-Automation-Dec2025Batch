package day13;

import java.awt.Dimension;
import java.awt.Toolkit;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchChrome {

	public static void main(String[] args) {
		try (Playwright pw = Playwright.create()) {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			double width = screenSize.getWidth();
			double height = screenSize.getHeight();
			System.out.println(width + " test screen size " + height);

			Browser browser = pw.chromium().launch(
					new BrowserType.LaunchOptions().setHeadless(false));

			BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width, (int)height));
			Page page = context.newPage();

			page.navigate("https://swautomationtester-dot.github.io/IshaDemoSite/index.html");
			page.pause();
		}
	}

}
