package Collections;


import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;

public class a4 {
	
	public static void main(String[] args) {
		
//		Set<String> set = new HashSet<>();
//		Set<String> set = new TreeSet<>();
		Set<String> set = new LinkedHashSet<>();
		System.out.println(set.size());

		set.add("BBB");
//		list.add(1);
		set.add("GGGG");
		set.add("AXAXA");
		set.add("AXAXA");
		set.add("AXAXA");
		set.add("axxaxx");
		set.add("TT");
		
		System.out.println(set.size());
		System.out.println(set);
		
		
				
	}

}
