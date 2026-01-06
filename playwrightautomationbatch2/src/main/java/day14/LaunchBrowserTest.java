package day14;

import java.nio.file.Paths;

import com.microsoft.playwright.Page;

public class LaunchBrowserTest {
	
	public static void main(String[] args) {
		
		Page page = BrowserFactory.initBrowser("edge", true, false);
		page.navigate("https://swautomationtester-dot.github.io/isha-automation-ui/");
		System.out.println(page.title());
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/fullpage.png")));
		page.waitForTimeout(2000);
		BrowserFactory.closeBrowser();
	}

}
