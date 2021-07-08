package a;

import java.util.Scanner;

public class InputDemo1 {

	public static void main(String[] args) {
		
		System.out.print("enter your name: ");
		
		Scanner sc = new Scanner(System.in);
		String userName = sc.nextLine();
		
		System.out.println("Hello " +userName);
		
		sc.close();
	
		
		
		
		
	}

}
