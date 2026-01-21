package day21;

import com.microsoft.playwright.Page;

public class ActionsTest {
	
	public static void main(String[] args) {
		Page page = day14.BrowserFactory.initBrowser("chrome", false, true);
		page.navigate("https://vrqaacademy.co.in/labs/drag-drop.html");
		page.dragAndDrop("#src", "#tgt");
	}
}
