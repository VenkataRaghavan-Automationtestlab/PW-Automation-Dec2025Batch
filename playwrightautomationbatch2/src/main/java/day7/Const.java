package day7;

public class Const {
	static String test;
	static int i;
	
	public static void main(String[] args) {
		System.out.println(test);
		System.out.println(i);
		System.out.println("Main");
		
		AccessSpecifiers as = new AccessSpecifiers();
		as.logMessage();
	}
	
}
