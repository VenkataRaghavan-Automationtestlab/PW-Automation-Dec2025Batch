package authstorageAdvanced;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    protected String role = "user";

    @BeforeMethod
    public void setup() {

        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        // 1️⃣ Create context from saved session
        context = AuthUtil.getAuthenticatedContext(browser, role);
        page = context.newPage();

        // 2️⃣ Self-heal: verify session is alive
        page.navigate("https://swautomationtester-dot.github.io/IshaDemoV1/inventory.html");

        if (page.url().contains("index.html")) {
            System.out.println("⚠️ Session invalid during test start. Auto-healing...");

            context.close();

            // Force regenerate and recreate context
            AuthUtil.forceRegenerate(browser, role);


            context = AuthUtil.getAuthenticatedContext(browser, role);
            page = context.newPage();
            page.navigate("https://swautomationtester-dot.github.io/IshaDemoV1/inventory.html");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
