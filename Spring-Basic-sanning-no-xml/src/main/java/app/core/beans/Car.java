package app.core.beans;

import org.springframework.stereotype.Component;

@Component
public class Car {

	private int Number;
	private int Speed;
	
	{
		System.out.println("car Created");
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public int getSpeed() {
		return Speed;
	}

	public void setSpeed(int speed) {
		Speed = speed;
	}

	public Car(int number, int speed) {
		super();
		Number = number;
		Speed = speed;
	}

	public Car() {
		super();
	}

	@Override
	public String toString() {
		return "Car [Number=" + Number + ", Speed=" + Speed + "]";
	}

}
