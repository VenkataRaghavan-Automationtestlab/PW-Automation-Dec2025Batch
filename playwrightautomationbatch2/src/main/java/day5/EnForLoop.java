package day5;

public class EnForLoop {
	
	public static void main(String[] args) {
		
		
		String[] fruits = {"Apple", "Mango" };
		
//		for(int i = 0; i <= fruits.length-1; i++) {
//			System.out.println(fruits[i]);
//		}
//		
		for(String fruit : fruits) {
			System.out.println(fruit);
		}
		
	}

}
