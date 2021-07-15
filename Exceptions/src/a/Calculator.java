package a;

public class Calculator {
	
	public int divide (int a, int b) throws Exception {
		if (b!=0) {
			int res = a/b ;
			return res;
			
		}else {
			Exception e = new Exception ("divide by 0");
			throw e;
		}
	}
}
