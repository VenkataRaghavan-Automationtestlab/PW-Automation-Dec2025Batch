package day9;

public interface Vehicle {
	
	default void landinfo() {
		System.out.println("test vehicle");
	}
	
	static void Launch() {
		System.out.println("Static method");
	}
	
	void method1();
	
}
