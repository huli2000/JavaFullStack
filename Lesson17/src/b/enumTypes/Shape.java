package b.enumTypes;

public class Shape {
	
	private ShapeColor color;

	public ShapeColor getColoer() {
		return color;
	}

	public void setColoer(ShapeColor coloer) {
		this.color = coloer;
	}
	
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.setColoer(ShapeColor.GREEN);
		System.out.println(shape.getColoer());
		
	}

}
