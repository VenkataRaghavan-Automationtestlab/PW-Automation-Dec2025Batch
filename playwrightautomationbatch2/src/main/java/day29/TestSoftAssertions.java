package day29;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TestSoftAssertions {
	
	public static void main(String[] args) {
		
		SoftAssert sa = new SoftAssert();

	    sa.assertEquals("Login", "Login123");
	    System.out.println("Execution1 is over");

	    sa.assertEquals("Login", "Login123");
	    System.out.println("Execution2 is over");
	    
	    String actualTitle = "Dashboard";
	    
	    Assert.assertEquals(actualTitle, "Dashboard");
	    System.out.println("This will execute");

	    System.out.println("all Execution is over");
	    
	    sa.assertAll(); // Mandatory
	}

}
