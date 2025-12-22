package day6;

public class TwoDimension {

	
	public static void main(String[] args) {
		
		int [][][] number = {
				{
					{1,2,5}, {3,4,6},{5,8,9}
				},
				{
					{1,2,5}, {3,4,6},{5,8,9}
				}};
		System.out.println(number[0][0][1]);
		
//		for(int row = 0; row <number.length; row++) {
//			for (int col = 0; col <number[row].length; col++) {
//				System.out.print(number[row][col] + " ");
//			}
//		}
	}
}
