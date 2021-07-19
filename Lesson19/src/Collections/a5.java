package Collections;


import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

public class a5 {
	
	public static void main(String[] args) {
		
		List<String> list = new LinkedList<>();
		System.out.println(list.size());

		list.add("BBB");
//		list.add(1);
		list.add("GGGG");
		list.add("AXAXA");
		list.add("AXAXA");
		list.add("AXAXA");
		list.add("axxaxx");
		list.add("TT");
		
		System.out.println(list.size());
		System.out.println(list);
		
		
				
	}

}
