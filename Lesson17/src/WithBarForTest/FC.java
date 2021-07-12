package WithBarForTest;

import java.util.Arrays;

public class FC {

	public static void main(String[] args) {
		
		int[] arr1 = new int[15];
		int[] arr2 = new int[15];
		
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = (int) ((Math.random()*10));
			arr2[i] = (int) ((Math.random()*10));
			
		}
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr1));
	}
	
	
}
