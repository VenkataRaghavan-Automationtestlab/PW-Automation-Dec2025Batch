package day19;

import com.microsoft.playwright.Page;

import day14.BrowserFactory;

public class AlertsHandling {
	
	
	public static void main(String[] args) {
		Page page = BrowserFactory.initBrowser("chrome", false, false);
		page.navigate("https://swautomationtester-dot.github.io/VRQA/labs/alerts.html");
		
		page.click("#modernConfirm");
		page.click("#modalCancel");
		
		String toastmsg = page.locator(".toast.success.show").innerText();
		System.out.println(toastmsg);
	}

}
