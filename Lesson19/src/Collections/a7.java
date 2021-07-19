package Collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

public class a7 {

	public static void main(String[] args) {

		List<Integer> list = new LinkedList<>();
		for (int i=0; i<25; i++) {
			list.add((int)(Math.random()*11));
		}
	
		System.out.println(list);
		
		Set<Integer> = set new LinkedHashSet<>(list);
		System.out.println(set);
		

	}

}
