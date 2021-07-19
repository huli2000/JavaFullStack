package a;

import java.util.Scanner;

public class TestRec3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Rectangle r = new Rectangle(0, 0);
		while (true) {
			try {
				System.out.println("enter legnth: ");
				r.setL(sc.nextInt());
				System.out.println("enter width: ");
				r.setW(sc.nextInt());
				break;
			} catch (Exception e) {
				System.out.println("Wrong input: " + e.getMessage());
				;
			}
		}
		sc.close();
		System.out.println(r);

	}

}
