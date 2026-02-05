package stepdefinitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {

	private static Playwright playwright;
	private static Browser browser;
	private static BrowserContext context;
	private static Page page;

	@Given("Open the chrome browser")
	public void open_the_chrome_browser() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome") // launch Chrome
				.setHeadless(false));
		context = browser.newContext();
		page = context.newPage();
		page.setViewportSize(1920, 1080);
	}

	@And("load the application URL")
	public void load_the_application_url() {
		page.navigate("https://login.vrqaacademy.co.in/index.html");
	}

	@When("enter the valid username {string}")
	public void enter_the_valid_username(String Username) {
		page.fill("#loginUsername", Username);
	}

	@And("enter the valid password {string}")
	public void enter_the_valid_password(String Password) {
		page.fill("#loginPassword", Password);
	}

	@Then("Click on login button")
	public void click_on_login_button() {
		page.click("[type='submit']");
	}
	
	@When("enter the invalid username")
	public void enter_the_invalid_username() {
		page.fill("#loginUsername", "Admin");
	}

	@And("enter the invalid password")
	public void enter_the_invalid_password() {
		page.fill("#loginPassword", "admin");
	}
}
