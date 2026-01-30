package day1;

import java.nio.file.Paths;
import java.util.Arrays;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.SelectOption;

public class Dropdown {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch();

		BrowserContext context = browser.newContext();
		Page page = context.newPage();

		// START TRACE
		context.tracing().start(
		    new Tracing.StartOptions()
		        .setScreenshots(true)
		        .setSnapshots(true)
		        .setSources(true)
		);

		page.navigate("https://vrqaacademy.co.in/");
		page.click("text=Text fields, password, validation, forms");

		// STOP TRACE
		context.tracing().stop(
		    new Tracing.StopOptions()
		        .setPath(Paths.get("traces/example_trace.zip"))
		);

		context.close();
		browser.close();
		playwright.close();	
	}
}
