package day1;

import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SearchDropdown {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
				.setArgs(Arrays.asList("--start-maximized")).setSlowMo(1000));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = context.newPage();
		page.navigate("https://swautomationtester-dot.github.io/isha-automation-ui2.0/");
		page.evaluate("document.getElementById('in-firstname').value = 'admin'");
		
		Locator button = page.locator("#validateInputs");
		page.evaluate("document.querySelector('#validateInputs').click()");

		page.locator("#validateInputs").evaluate("el => el.style.border = '3px solid red'");
//		document.querySelector('#validateInputs').style.border='3px solid red'
	}
}
