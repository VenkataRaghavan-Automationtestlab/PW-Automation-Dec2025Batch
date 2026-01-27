package day26;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.microsoft.playwright.Page;
import day14.BrowserFactory;
import java.nio.file.Paths;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestExtentReport {
	
	public static void main(String[] args) {
		
		Page page = BrowserFactory.initBrowser("chrome", false, true);
		
		// 1. Setup Extent
		ExtentSparkReporter reporter = new ExtentSparkReporter("report.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);

		// 2. Create test
		ExtentTest test = extent.createTest("Login Test").assignAuthor("Venkataraghavan");
		test.assignCategory("Smoke");
		test.assignDevice("chrome 151");
		
		reporter.config().setDocumentTitle("Extent Report Demo");
		reporter.config().setReportName("Swaglabs Login test");
		reporter.config().setTheme(Theme.DARK);
		
		extent.setSystemInfo("Application", "SwagLabs");
		extent.setSystemInfo("Environment", "SwagLabs-QA");
		extent.setSystemInfo("Browser", "Chrome");
		
		// 3. Test steps
		page.navigate("https://www.saucedemo.com/v1/index.html");
		test.info("Navigated to site");

		page.locator("input[type='text']").fill("standard_user");
		test.info("Entered username");

		page.locator("#password").fill("secret_sauce");
		test.info("Entered password");

		page.locator("#login-button").click();
		test.info("Clicked login");
		
		// 4. Screenshot
		String path = "screenshot.png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath(path);

		// 5. Log results
		test.pass("Login successful");

		// 6. Flush report
		extent.flush();
	}

}
