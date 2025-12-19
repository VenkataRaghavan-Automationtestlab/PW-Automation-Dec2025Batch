package day4;

public class Operators {

	public static void main(String[] args) {
		int Ten = 10;
		int Twenty = 20;
		int Thirty = 30;
		
		boolean bValue;
		int iValue;
		String sValue;
		
		
		bValue = (Thirty == Twenty) ? true: false;
		System.out.println( "The boolean value of the variable 'bValue' is : " + bValue ); //true

		iValue = ((Thirty == Twenty)) ? 50: 100;
		System.out.println( "The int Value of the variable iValue is : " + iValue ); //50
		
		
		sValue = ((Thirty == Twenty + Ten)) ? "yes": "no";
		System.out.println( "The int Value of the variable iValue is : " + sValue ); //50
	}
	
}
