package a;

 public class CarTest {

	public static void main(String[] args) {
		
		// static reference - using class name
		System.out.println(Car.name);
		
		// dynamic reference - using instance name
		Car car1 = Car.createCar();
//		car1.number = 123;
		Car car2 = Car.createCar();
//		car2.number = 456;
		System.out.println(car1.number);
		System.out.println(car2.number);
		
		System.out.println(Car.name);
		
		Car car3 = Car.createCar();
		System.out.println(car3.number);

	}

}
