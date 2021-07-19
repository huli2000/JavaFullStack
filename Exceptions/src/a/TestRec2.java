package a;

import java.util.Scanner;

public class TestRec2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Rectangle r = new Rectangle(0, 0);
		try {
			System.out.println("enter legnth: ");
			r.setL(sc.nextInt());
			System.out.println("enter width: ");
			r.setW(sc.nextInt());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			sc.close();
		}
		System.out.println(r);

	}

}
