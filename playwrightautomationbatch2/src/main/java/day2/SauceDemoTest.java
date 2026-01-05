package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoTest {

    public static void main(String[] args) {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Navigate to URL
        driver.get("https://www.saucedemo.com/");

        // Get and print title
        String title = driver.getTitle();
        System.out.println(title);

        // Enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Click login button
        driver.findElement(By.id("login-button")).click();

        // Close browser
//         driver.quit();
    }
}
