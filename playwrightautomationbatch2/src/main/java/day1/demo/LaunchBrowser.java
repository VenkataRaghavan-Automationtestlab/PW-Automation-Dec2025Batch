package day1.demo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class LaunchBrowser {
	
	public static void main(String[] args) {
		
		try (Playwright playwright = Playwright.create()) {
		      BrowserType chromium = playwright.chromium();
		      // Make sure to run headed.
		      Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
		      // Setup context however you like.
		      BrowserContext context = browser.newContext(/* pass any options */);
		      context.route("**/*", route -> route.resume());
		      // Pause the page, and start recording manually.
		      Page page = context.newPage();
//		      page.pause();
		      page.navigate("https://swautomationtester-dot.github.io/IshaDemoV1/");
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill("admin");
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).press("Tab");
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("admin");
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).press("Tab");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("admin123");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart")).first().click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logout")).click();
		      System.out.println("Execution is over");
		    }
	}
}
