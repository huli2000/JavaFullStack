package a;

public class TestRec {

	public static void main(String[] args) {
		Rectangle r = new Rectangle(0, 0);
		try {
			
			r.setL(15);
			r.setW(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(r);

	}

}
