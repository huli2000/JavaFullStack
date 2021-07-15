package calc;

public class Calculator {

		public void divide (int a, int b) {
			if (b != 0) {
				return a / b;
			}else {
				System.out.println("error");
				return 0;
			}
		}
}
