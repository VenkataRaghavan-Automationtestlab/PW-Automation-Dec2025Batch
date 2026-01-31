package day28;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class TestNGAnnotations {

	// test case 1
	@Test(groups = {"Smoke"})
	public void testCase1() {
		System.out.println("----in test case 1");
	}

	// test case 2
	@Test(groups = {"Smoke"})
	public void testCase2() {
		fail();
		System.out.println("----in test case 2");
	}

	// test case 3
	@Test(groups = {"Regression"})
	public void testCase3() {
		System.out.println("----in test case 3");
	}
}
