package day1;

import com.microsoft.playwright.*;

public class WindowHandlingTestleaf {
  public static void main(String[] args) {
    Playwright pw = Playwright.create();
    Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    BrowserContext context = browser.newContext();
    Page page = context.newPage();

    page.navigate("https://www.leafground.com/window.xhtml");

 // Click Open Multiple
    page.click("text=Open Multiple");

    // Small wait for windows to open
    page.waitForTimeout(3000);

    // Get all pages
    System.out.println("Total Windows: " + context.pages().size());

    for (Page p : context.pages()) {
        System.out.println("Window Title: " + p.title());
    }

    Page parent = page;

    for (Page Child : context.pages()) {
        if (Child != parent) {
        	Child.close();
        }
    }

    // Ensure parent is active
    parent.bringToFront();

  }
}
