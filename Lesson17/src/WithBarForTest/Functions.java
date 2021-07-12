package WithBarForTest;

public class Functions {

	public static int[] Index() {
		
		int[] arr = new int[15];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random()*10);
		}
		return arr;
	}
	
}
