package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class a3 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

	
		Map<String, String> map = new HashMap<>();
		System.out.println(map);

		map.put("Israel", "Country");
		map.put("Moshe", "Name");
		map.put("Three", "Number");

		System.out.println(map.get("Israel"));

		System.out.println("============");
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter word: ");
			String word = sc.nextLine();
			if (word.equals("q")) {
				break;
			}
			String def = map.get(word);
			if (def != null) {
				System.out.println(map.get(word));
			} else {
				System.out.println("The word: " + word + " is not exsist");
				System.out.println("would you like to add the word? y/n");
				String input = sc.nextLine();
				if (input.equalsIgnoreCase("y")) {
					System.out.println("enter defenition: ");
					def = sc.nextLine();
					map.put(word, def);
					System.out.println(word + " add to dictionary");
				}else {
					System.out.println(word + " was not added");
				}
			}
		}
		System.out.println("Bye");
//		sc.close();

	}

}
