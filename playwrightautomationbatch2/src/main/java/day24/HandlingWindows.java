package day24;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingWindows {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://www.leafground.com/window.xhtml");

			Page parent = page;

			Page child = page.waitForPopup(() -> {
				page.click("(//*[@class='ui-button-text ui-c'])[1]");
			});

			System.out.println("Child title: " + child.title());

			// Do actions in child
			child.locator("text='Edit Profile'").scrollIntoViewIfNeeded();

			// Switch back to parent
			parent.bringToFront();

			page.click("text='Open Multiple'");

			parent.bringToFront();

			System.out.println("Total Window Size: " + context.pages().size());

			for (Page p : context.pages()) {
				if (p != parent) {
					System.out.println(p.title());
					p.close();
				}
			}
			parent.bringToFront();
		}
	}
}
