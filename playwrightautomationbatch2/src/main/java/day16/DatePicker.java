package day16;

import com.microsoft.playwright.Page;

import day14.BrowserFactory;

public class DatePicker {

	public static void main(String[] args) {
		Page page = BrowserFactory.initBrowser("chrome", false, false);
		// Example: imagine this is your app
        page.navigate("https://swautomationtester-dot.github.io/isha-automation-ui2.0/");
        
        page.fill("#datePicker", "1991-06-02");
	}

}
