package authStorageBasic;

import com.microsoft.playwright.*;
import org.testng.annotations.*;
import java.nio.file.Paths;

public class BaseTest {

  protected Playwright playwright;
  protected Browser browser;
  protected BrowserContext context;
  protected Page page;

  @BeforeMethod
  public void setup() {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(
      new BrowserType.LaunchOptions().setHeadless(false)
    );

    context = browser.newContext(
      new Browser.NewContextOptions()
        .setStorageStatePath(Paths.get("authstorageAdvanced.json"))  // 🔥 LOAD SAVED LOGIN
    );

    page = context.newPage();
  }

  @AfterMethod
  public void tearDown() {
    context.close();
    browser.close();
    playwright.close();
  }
}
