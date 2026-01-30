package day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowHandling {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.leafground.com/window.xhtml");
	    
	    Page newPage = context.waitForPage(() -> {
	        page.click("(//*[@class='ui-button-text ui-c'])[1]");
	    });

	    newPage.waitForLoadState();

//	    Page child = page.waitForPopup(() -> {
//	        	page.click("(//*[@class='ui-button-text ui-c'])[1]");
//	    });
//
//	    child.waitForLoadState();
	    
//	    System.out.println("Child title: " + child.title());
//
//	    // Do actions in child
//	    child.locator("text='Edit Profile'").scrollIntoViewIfNeeded();
//
//	    // Switch back to parent
//	    parent.bringToFront();

	}
	

}
