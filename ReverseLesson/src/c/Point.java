package c;

public class Point implements Navigator {

	private int x;
	private int y;

	public Point() {
		super();
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	
	@Override
	public void navigate(int x, int y) {
		this.x = x;
		this.y = y;		
	}
}
