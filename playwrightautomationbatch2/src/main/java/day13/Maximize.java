package day13;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class Maximize {

    public static void main(String[] args) {

        Playwright pw = Playwright.create();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        Browser browser = pw.chromium().launch(
            new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(500)
        );

        BrowserContext context = browser.newContext(
            new Browser.NewContextOptions()
                .setViewportSize(width, height)
                .setRecordVideoDir(Paths.get("videos"))
                .setRecordVideoSize(1280, 720)
        );

        // ✅ START tracing
        context.tracing().start(
            new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true)
        );

        Page page = context.newPage();
        page.navigate("https://www.saucedemo.com/");
        page.fill("#user-name", "standard_user");
        page.fill("#password", "secret_sauce");
        page.click("#login-button");

        // ✅ Give time for video buffer
        page.waitForTimeout(2000);

        // ✅ STOP tracing (MANDATORY)
        context.tracing().stop(
            new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip"))
        );

        // ✅ Close order matters
        context.close();   // saves video
        browser.close();
        pw.close();
    }
}
