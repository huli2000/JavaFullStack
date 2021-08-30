package c;

public class Pixel extends Point {

	private Color color;

	public Pixel(int x, int y, Color color) {
		super(x,y);
		this.color = color;
	}

	@Override
	public String toString() {
		return "Pixel [color=" + color +" ,x=" + x + " ,y=" + y]";"
	}

	
	
}
