package base;

import com.microsoft.playwright.*;

public class BaseTest {

    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;

    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000)
        );
        context = browser.newContext();
        page = context.newPage();
    }

    public void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }
}
