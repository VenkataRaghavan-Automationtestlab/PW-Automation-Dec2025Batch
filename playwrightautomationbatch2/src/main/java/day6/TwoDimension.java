package day6;

public class TwoDimension {

	
	public static void main(String[] args) {
		
		int [][] num = {{1,2,5},{3,4,6}};
		System.out.println(num[1][2]);
		
		for(int row = 0; row <num.length; row++) {
			for (int col = 0; col <num[row].length; col++) {
				System.out.print(num[row][col] + " ");
			}
		}
	}
}
