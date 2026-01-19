package day15;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import day14.BrowserFactory;

public class Disabled {

	public static void main(String[] args) {
		
		Page page = BrowserFactory.initBrowser("chrome", false, false);

        page.navigate("https://swautomationtester-dot.github.io/isha-automation-ui2.0/");
		
		Locator checkbox = page.locator("#chk-Apple");
		
		if(checkbox.isDisabled()) {
			System.out.println("element is disabled");
		}else 
		{
			System.out.println("element is not disabled");
		}
		
		Locator discheckbox = page.locator("#chk-Orange");
		
		if(discheckbox.isDisabled()) {
			System.out.println("element is disabled");
		}else 
		{
			System.out.println("element is not disabled");
		}

	}

}
