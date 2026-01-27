package day1.demo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowser {
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		      BrowserType chromium = playwright.chromium();
		      
		      Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		      
		      BrowserContext context = browser.newContext();
		      
		      Page page = context.newPage();
		      
		      page.navigate("https://login.vrqaacademy.co.in/index.html");
		      
		      page.fill("#loginUsername", "admin");
		      page.fill("#loginPassword", "admin123");
		      
		      page.click("[type='submit']");
		      
		      page.locator("[data-id='p3']").first().click();
		      
		      page.click("#cartBtn");
		      
		      page.click("#checkoutBtn");
		      
		      page.fill("#fullName", "Ramesh");
		      
		      page.fill("#address", "1st Cross Street, Chennai");
		      
		      page.fill("#cardNumber", "1234 5647 4856 4656");
		      
		      page.fill("#expiry", "12/26");
		      
		      page.fill("#cvc", "123");
		      
		      page.click("#payBtn");
		      
		      page.click("[onclick='confirmPayment()']");
		      
		      String orderdetails = page.locator("#orderDetails").innerText();
		      
		      System.out.println(orderdetails);
	}
}
