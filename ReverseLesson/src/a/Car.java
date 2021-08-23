package a;

public class Car {
	 
	//1. fields  =========================
	//belong to class - static
	public static final String name = "car factory";
	private static int counter = 100_000;
	
	
	//belong to car objects - dynamic
	private int km; // access from the same class only
	String type; //default - no access modifier - access from any class in this package
	protected String color; //access from package and any sub class
	public final int number; // access from anywhere

	
	//2. CTORs =========================
	private Car() {
		this.number = counter;
	}
	
	// 3. methods -  =========================
	
	
//	public static String getName() {
//		return Car.name;
//	}
	
	// static method - class method
public static Car createCar () {
	Car car = new Car();
	counter ++;
//	car.number = counter;
	return car; // return a Car
}

public int drive (int speed, int distance) {
	 System.out.println("car number " + this.number + " is driving " + speed + " km/h");
	this.km += distance;
	 return this.km; // return no value - null
	}
	
public int getKm() {
	return this.km;
}
}
 

