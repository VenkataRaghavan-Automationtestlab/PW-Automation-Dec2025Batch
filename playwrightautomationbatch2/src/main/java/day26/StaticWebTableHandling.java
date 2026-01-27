package day26;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import day14.BrowserFactory;

public class StaticWebTableHandling {
	
	public static void main(String[] args) {
		Page page = BrowserFactory.initBrowser("chrome", false, true);
		page.navigate("https://vrqaacademy.co.in/labs/tables.html");
		
//		Locator rows = page.locator("//*[@id='staticTable']/tbody/tr");
//		int rowcount = rows.count();
//		
//		System.out.println(rowcount);
//		
//		Locator cols = page.locator("#staticTable thead th");
//		int colcount = cols.count();
//		
//		System.out.println(colcount);
		
		Locator rows = page.locator("//*[@id='staticTable']/tbody/tr");
		
		for(int i = 0; i < rows.count(); i++) {
			Locator cells = rows.nth(i).locator("td");
			
			for(int j=0;j<cells.count();j++) {
				System.out.print(cells.nth(j).textContent()+ " | ");
			}
			System.out.println();
		}
		
		String tablevalue = page.locator("//*[@id='staticTable']/tbody/tr[3]/td[2]").textContent();
		System.out.println(tablevalue);
	}

}
