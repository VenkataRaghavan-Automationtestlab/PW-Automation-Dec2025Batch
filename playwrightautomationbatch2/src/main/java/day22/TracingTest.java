package day22;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class TracingTest {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
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
		page.fill("#in-firstna", "Venkat");
		page.fill("#in-lastna", "raghavan");
		
		
		// STOP TRACE
		context.tracing().stop(
		new Tracing.StopOptions()
		.setPath(Paths.get("traces/Test_Failexample_trace.zip"))
		);

		context.close();
		browser.close();
		playwright.close(); 

	}

}
