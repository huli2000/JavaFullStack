package b;

public class Line {

	private int length;
	private String color;
	private char characterType;
	
	public void draw() {
		System.out.print(this.color + ": ");
		for (int i = 0; i < length; i++) {
			System.out.print(characterType);
			
		}
		System.out.println();
		{}}
		//CTOR 1
		public Line() {
			
		}
		//CTOR 2
		public Line (String color, int length, char characterType) {
			this.color = color;
			this.length = length;
			this.characterType = characterType;
	}
	
		//CTOR 3
		public Line (int length) {
			this ("black" , length, '.');
		}
	
	public static void main(String[] args) {
		Line line = new Line();
		line.length = 15;
		line.color = "Blue";
		line.characterType = '*';
		line.draw();
		
		Line line2 = new Line("Red", 20, '?');
		line2.draw();
		
		Line line3 = new Line(12);
		line3.draw();
	}
}
