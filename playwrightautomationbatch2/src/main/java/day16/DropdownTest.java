package day16;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import day14.BrowserFactory;

public class DropdownTest {
	
	public static void main(String[] args) {
		
		Page page = BrowserFactory.initBrowser("chrome", false, false);

        page.navigate("https://swautomationtester-dot.github.io/isha-automation-ui2.0/");
        
        Locator selectDD = page.locator("#country");
        selectDD.scrollIntoViewIfNeeded();
        
        String ddloc = "#searchableSelectInput";
        
//        page.fill(ddloc, "Cyp");
        page.waitForTimeout(2000);
        	
        Locator searchable = page.locator("#searchableSelectList div");
        
        for(int i = 0; i<searchable.count();i++) {
        	System.out.println(searchable.nth(i).innerText());
        }
        
//        searchable.filter(new Locator.FilterOptions().setHasText("Cypress")).first().click();
        
//        page.locator(".multi-select").scrollIntoViewIfNeeded();
//        page.locator(".multi-select").click();
//        page.getByText("Java").click();
	}

}
