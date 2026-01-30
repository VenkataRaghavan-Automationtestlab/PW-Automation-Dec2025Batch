package day1;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;

public class TestActions {
	
	public static void main(String[] args) {
		Page page = BrowserFactory.initBrowser("chrome", false, false);
		page.navigate("https://demo.guru99.com/test/simple_context_menu.html");

		// Right click
		page.locator("text='right click me'").click(
		    new Locator.ClickOptions().setButton(MouseButton.RIGHT)
		);

		
	}

}
