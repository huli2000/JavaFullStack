package a;

public class Car {
	//belong to class - static
	public static final String name = "car factory";
	private static int counter = 100_000;
	// static method - class method
	
//	public static String getName() {
//		return Car.name;
//	}
	
	// static method - class method
public static Car createCar () {
	Car car = new Car();
	counter ++;
//	car.number = counter;
	return car;
}
	//belong to car objects - dynamic
	public final int number;

	
	//CTOR =========================
	private Car() {
		this.number = counter;
	}
	
	
	}


