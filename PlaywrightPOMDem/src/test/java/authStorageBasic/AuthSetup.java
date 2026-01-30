package authStorageBasic;

import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class AuthSetup {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {

      Browser browser = playwright.chromium().launch(
        new BrowserType.LaunchOptions().setHeadless(false)
      );

      BrowserContext context = browser.newContext();
      Page page = context.newPage();

      page.navigate("https://swautomationtester-dot.github.io/IshaDemoV1/index.html");

      page.fill("#username", "admin");
      page.fill("#password", "admin123");
      page.click("button[type='submit']");

      // Wait until inventory page loads
      page.waitForURL("**/inventory.html");

      // 🔥 Save authstorageAdvanced state
      context.storageState(new BrowserContext.StorageStateOptions()
        .setPath(Paths.get("authstorageAdvanced.json")));

      System.out.println("✅ authstorageAdvanced.json created successfully!");

      browser.close();
    }
  }
}
