package c;

public class Car extends Vehicle{

	public Car(int number) {
		super(number);
	}

	@Override
	public void navigate(int x, int y) {
		this.location.x = x;
		this.location.y = y;
	}

	@Override
	public void drive() {
		System.out.println("car is driving");
	}
	
	

}
