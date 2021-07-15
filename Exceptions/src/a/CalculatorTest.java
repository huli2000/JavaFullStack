package a;

public class CalculatorTest {

	public static void main(String[] args) {
		
		Calculator c = new Calculator();
		
		try {
			int res = c.divide(10, 0);
			System.out.println(res);
			} catch (Exception e) {
				
				System.out.println("Error: " + e.getMessage());
			}
		System.out.println("END");
	}

}
