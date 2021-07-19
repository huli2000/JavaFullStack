package Collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class a {

	public static void main(String[] args) {

		Set<Integer> set = new LinkedHashSet<>();
		while (set.size() < 10) {
			boolean x = set.add((int) (Math.random() * 11));
			System.out.println(x);
		}

		System.out.println(set);

	}

}
