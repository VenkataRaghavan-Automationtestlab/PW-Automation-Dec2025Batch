package day6;

import java.util.Arrays;

public class ArraysImp {

	public static void main(String[] args) {
		
		
		String [] aMake = {"BMW","AUDI","TOYOTA","SUZUKI","HONDA", "TVS"};
		
		//This is to store the size of the Array
		int Size = aMake.length;
		System.out.println(Size);
		
		//This is to access the first element of an array directly with it's position
		String sBMW = aMake[0];
		System.out.println("First value of the Array is ==> " + sBMW);
		
		//This is to access the last element of an Array
		String sHonda = aMake[Size-1];
		System.out.println("Last value of the Array is ==> " + sHonda);

		int[] scores = {40, 20, 60, 10};
		Arrays.sort(scores);
		System.out.println(Arrays.toString(scores)); // [10, 20, 40, 60]

	}
}
