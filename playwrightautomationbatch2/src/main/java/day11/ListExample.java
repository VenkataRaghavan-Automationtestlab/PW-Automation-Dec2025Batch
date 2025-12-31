package day11;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
	
	public static void main(String[] args) {
		
		
		List<String> ls = new ArrayList<>();
		
		ls.add("Apple");
		ls.add("Mango");
		ls.add("Gauva");
		ls.add("Berry");
		
		System.out.println(ls);
		
		ls.add(2, "Tret");
		System.out.println(ls);
	}

}
