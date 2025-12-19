package day3;

public class Methods {
	
	public static void sayHello() {
	    System.out.println("Hello!");
	}
	
	public int getNumber() {
	    return 10;
	}
	
	public void printName(String name) {
	    System.out.println("Name: " + name);
	}

	public int add(int a, int b) {
	    return a + b;
	}

	public static void main(String[] args) {
		
		Methods m = new Methods();
		sayHello();
		System.out.println(m.add(10, 5));
		System.out.println(m.getNumber());
		m.printName("Hari");
	}
	
}
