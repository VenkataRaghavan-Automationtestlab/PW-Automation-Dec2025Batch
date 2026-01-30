package day1;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class TableHandling {
	
	public static void main(String[] args) {
		
		Page page = BrowserFactory.initBrowser("chrome", false, true);
		page.navigate("https://vrqaacademy.co.in/labs/tables.html");
		page.setDefaultTimeout(5000);
		
		page.locator("#tableBody tr:has(td:text('Selenium')) button:has-text('Edit')").click();

		// Update
		page.fill("#coursePrice", "999");
		page.click("#saveBtn");

		// Verify
		Locator priceCell = page.locator("#tableBody tr:has(td:text('Selenium')) td:nth-child(2)");
		PlaywrightAssertions.assertThat(priceCell).hasText("999");
		
	}

}
