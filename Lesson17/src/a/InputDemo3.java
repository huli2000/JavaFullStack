package a;

import java.util.Scanner;

public class InputDemo3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("enter your first number: ");
		
		
		double num1 = sc.nextDouble();
		
		System.out.print("enter your second number: ");
		double num2 = sc.nextDouble();
		
		double sum = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + sum);
		
		sc.close();
	
		
		
		
		
	}

}
