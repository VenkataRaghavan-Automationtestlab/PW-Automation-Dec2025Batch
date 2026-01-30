package day1;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

public class Testshadow {
	
	public static void main(String[] args) {
		Page page = BrowserFactory.initBrowser("chrome", false, true);
		page.navigate("https://vrqaacademy.co.in/labs/shadow.html");
		

	      // 1️ BASIC SHADOW DOM - <shadow-login> -> #user, #btn
	      page.locator("shadow-login >> #user").fill("Venkat");
	      page.locator("shadow-login >> #btn").click();

	      // Validate result
	      page.waitForSelector("#basicResult");
	      System.out.println("Basic Result: " + page.locator("#basicResult").textContent());
	      

	      // 2️ NESTED SHADOW DOM - <shadow-parent> -> <shadow-child> -> #childInput, #childBtn
	      page.locator("shadow-parent >> shadow-child >> #childInput").fill("Playwright");
	      page.locator("shadow-parent >> shadow-child >> #childBtn").click();

	      // Validate result
	      page.waitForSelector("#nestedResult");
	      System.out.println("Nested Result: " + page.locator("#nestedResult").textContent());

	      

	      // 3️ SHADOW DOM INSIDE IFRAME - iframe -> <shadow-login> -> #user, #btn
	      FrameLocator frame = page.frameLocator("#shadowIframe");

	      frame.locator("shadow-login >> #user").fill("InsideFrame");
	      frame.locator("shadow-login >> #btn").click();

	      // Validate iframe result on main page
	      page.waitForSelector("#iframeResult");
	      System.out.println("Iframe Result: " + page.locator("#iframeResult").textContent());

	}

}
