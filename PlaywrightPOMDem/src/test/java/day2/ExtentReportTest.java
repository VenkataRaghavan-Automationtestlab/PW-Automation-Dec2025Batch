package day2;

import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ExtentReportTest {

	public static void main(String[] args) {

		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
			Page page = browser.newPage();

			ExtentReports extent = new ExtentReports();
			ExtentSparkReporter reporter = new ExtentSparkReporter("report.html");
			reporter.config().setDocumentTitle("Extent Report Demo");
			reporter.config().setReportName("Swag labs login validation");
			reporter.config().setTheme(Theme.DARK);
			extent.attachReporter(reporter);
			extent.setSystemInfo("Application", "Swag Labs");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Browser", "Chrome");
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Tester", "Venkat");
			ExtentTest test = extent.createTest("Login Test").assignAuthor("Raghavan");
			test.assignAuthor("Raghavan", "Team A");
			test.assignCategory("Regression");
			test.assignDevice("Chrome 141");
			
			
			page.navigate("https://www.saucedemo.com/v1/index.html");
			test.pass("navigated successfully");
			String path = "screenshot.png";
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
			test.addScreenCaptureFromPath(path);
			page.waitForLoadState();
			page.waitForTimeout(2000);
			page.locator("input[type='text']").fill("standard_user");
			test.pass("username is typed successfully");
			page.locator("#password").fill("secret_sauce");
			test.pass("password is typed successfully");
			page.locator("#login-button").click();
			test.pass("login button is clicked successfully");
			test.pass("Navigated to login page");
			test.fail("failed Test");
			test.skip("skipped");
			test.info("info test");
			test.warning("warning test");
			extent.flush();
		}

	}

}

