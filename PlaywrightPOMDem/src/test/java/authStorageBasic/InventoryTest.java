package authStorageBasic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {

  @Test
  public void testOpenInventoryWithoutLogin() {

    page.navigate("https://swautomationtester-dot.github.io/IshaDemoV1/inventory.html");
    page.waitForTimeout(3000);
    
    // If not logged in, page would redirect to index.html
    String url = page.url();
    System.out.println("Current URL = " + url);

    Assert.assertTrue(url.contains("inventory.html"), "❌ Not logged in!");

    // Verify Logout button exists
    boolean logoutVisible = page.locator("#logoutBtn").isVisible();
    Assert.assertTrue(logoutVisible);

    System.out.println("✅ Login session reused successfully!");
  }
}
