package day21;

import com.microsoft.playwright.Page;

public class JsPlaywright {
	
	public static void main(String[] args) {
		Page page = day14.BrowserFactory.initBrowser("chrome", false, true);
		page.navigate("https://swautomationtester-dot.github.io/isha-automation-ui2.0/");
		page.evaluate("document.querySelector('#readonly-input').value = 'venkat';");
		page.evaluate("document.getElementById('in-firstname').value = 'admin';");
		page.evaluate("document.querySelector('#datePicker').value='2026-01-15'");
		page.locator("#validateInputs").evaluate("el => el.style.border = el.style.outline ? '' : '3px solid red'");
		page.evaluate("document.getElementById('generateInputs').style.border = '3px solid red';");
		page.locator("[type='submit']").evaluate("el => el.scrollIntoView()");
//		page.locator("[type='submit']").scrollIntoViewIfNeeded();
		page.locator("[type='submit']").evaluate("el => setInterval(() => el.style.outline = '3px solid red', 500)");

	}

}
