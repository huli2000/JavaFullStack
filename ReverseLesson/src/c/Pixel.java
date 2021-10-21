package c;

public class Pixel extends Point {

	private Color color;

	public Pixel(int x, int y, Color color) {
		super(x,y);
		this.color = color;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Pixel [color=" + color +" ,x=" + x + " ,y=" + y]";"
=======
		return "Pixel [color=" + color + ", x=" + x + ", y=" + y + "]";
>>>>>>> branch 'master' of https://github.com/huli2000/javafullstack.git
	}

	
	
}
