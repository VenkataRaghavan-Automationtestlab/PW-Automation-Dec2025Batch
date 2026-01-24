package day25;

import com.microsoft.playwright.Page;

import day14.BrowserFactory;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.regex.Pattern;

public class PW_Assertions {
	
	public static void main(String[] args) {
		Page page = BrowserFactory.initBrowser("chrome", false, true);
		page.navigate("https://vrqaacademy.co.in/");
		
		assertThat(page).hasTitle(Pattern.compile(".*Labs Dashboard.*"));
		System.out.println("execution is over");
	
	}

}
