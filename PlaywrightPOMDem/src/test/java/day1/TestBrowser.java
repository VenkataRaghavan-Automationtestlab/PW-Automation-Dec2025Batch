package day1;

import java.nio.file.Paths;

import com.microsoft.playwright.Page;

public class TestBrowser {

	public static void main(String[] args) {

		Page page = BrowserFactory.initBrowser("chrome", false, false);
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
//		page.onDialog(dialog -> {
//		    System.out.println("Alert message: " + dialog.message());
//		    dialog.accept();   // Click OK
//		});
//
//		page.click("text=Click for JS Alert");
		
		
//		page.onDialog(dialog -> {
//		    System.out.println(dialog.message());
//		    dialog.accept();   // OK
//		});
//
//		page.click("text=Click for JS Confirm");
		
//		page.onDialog(dialog -> {
//		    System.out.println(dialog.message());
//		    dialog.dismiss();  // Cancel
//		});
//
//		page.click("text=Click for JS Confirm");
		
//		page.onDialog(dialog -> {
//		    System.out.println(dialog.message());
//		    dialog.accept("Playwright Java");   // Enter text + OK
//		});

		String title = (String) page.evaluate("() => document.title");
		System.out.println(title);
		
		page.onceDialog(dialog -> {
		    String text = dialog.message();
		    System.out.println("Dialog says: " + text);
		    dialog.dismiss();
		});
		
		page.click("text=Click for JS Prompt");

	}
}
