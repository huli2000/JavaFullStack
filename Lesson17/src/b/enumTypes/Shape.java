package b.enumTypes;

import java.util.Arrays;
import java.util.Scanner;

public class Shape {
	
	private ShapeColor color;

	public ShapeColor getColor() {
		return color;
	}

	public void setColor(ShapeColor color) {
		this.color = color;
	}
	
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.setColor(ShapeColor.GREEN);
		System.out.println(shape.getColor());
		
		Scanner sc= new Scanner(System.in);
		System.out.println("choose your color " + Arrays.toString(ShapeColor.values()));
		String color = sc.nextLine();
		shape.setColor(ShapeColor.valueOf(color));
		System.out.println(shape);
		sc.close();
	}

}
