package day3;

public class Variables {
	String name;
	int age;
	
	public void showDetails() {
		System.out.println("Name: "+ name + " Age: "+ age);
	}
	
	public static void main(String[] args) {
		
		Variables v = new Variables();
		v.name = "Playwright";
		v.age = 56;
		v.showDetails();
	}
}
