package a;

import java.util.Scanner;

public class ARM {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);
				Phone p = new Phone();
				Phone p2 = new Phone();

		) {
			System.out.println("enter name: ");
			String name = sc.nextLine();
			System.out.println(name);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
