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
		      Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		      // Setup context however you like.
		      BrowserContext context = browser.newContext(/* pass any options */);
		      Page page = context.newPage();
		      page.navigate("https://swautomationtester-dot.github.io/isha-automation-ui2.0/");
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
//		      page.getByPlaceholder("Password").nth(1).fill("123456"); // login
//		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill("admin");
//		      page.getByRole(AriaRole.TEXTBOX).fill("admin");
//		      page.locator("button[type='submit']").click();
		      
		     
		    }
	}
}
