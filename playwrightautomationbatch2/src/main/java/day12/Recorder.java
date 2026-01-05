package day12;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class Recorder {
	 public static void main(String[] args) {
		    try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      Page page = browser.newPage();
		      page.navigate("https://swautomationtester-dot.github.io/IshaDemoSite/index.html");	
		      assertThat(page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username"))).isVisible();
		      assertThat(page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password"))).isVisible();
		      assertThat(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"))).isVisible();
		      assertThat(page.getByText("Demo credentials:")).isVisible();
		      assertThat(page.getByRole(AriaRole.HEADING)).containsText("ISHA Automation");
		      assertThat(page.locator("#loginForm")).containsText("Username");
		      assertThat(page.locator("#loginForm")).containsText("Password");
		      assertThat(page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username"))).isEmpty();
		      assertThat(page.getByRole(AriaRole.BUTTON)).matchesAriaSnapshot("- button \"Login\"");
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill("admin");
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("admin123");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		      assertThat(page.getByText("Isha Backpack")).isVisible();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart")).first().click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart:")).click();
		      assertThat(page.getByText("Isha Backpack")).isVisible();
		      assertThat(page.locator("#cartContainer").getByText("₹")).isVisible();
		      assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed to Checkout"))).isVisible();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed to Checkout")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Full name")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Full name")).fill("tests");
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Address")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Address")).fill("testset");
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Card Number")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Card Number")).fill("123142352525215");
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Expiry (MM/YY)")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Expiry (MM/YY)")).fill("23414");
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("CVC")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("CVC")).fill("3214");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pay Now")).click();
		      assertThat(page.locator("h2")).containsText("Thank you — your order is placed!");
		      page.getByText("Total: ₹").click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Shop more")).click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logout")).click();
		    }
	 }
}
