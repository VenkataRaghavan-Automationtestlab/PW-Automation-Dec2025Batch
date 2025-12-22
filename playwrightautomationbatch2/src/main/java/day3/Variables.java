package day3;

import day7.AccessSpecifiers;

public class Variables extends AccessSpecifiers{
	String name;
	int age;
	
	public void showDetails() {
		System.out.println("Name: "+ name + " Age: "+ age);
	}
	
	public static void main(String[] args) {
		
		Variables a = new Variables();
		a.logMessage();
	}
}
