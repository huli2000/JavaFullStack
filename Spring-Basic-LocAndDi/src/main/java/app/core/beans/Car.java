package app.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") 
public class Car {

	private int Number;
	private int Speed;
	@Autowired
	private Engine engine;
	
	{
		System.out.println("car Created");
	}
	
	public void start() {
		System.out.println("car is starting");
		this.engine.start();
		
	}
	public void stop() {
		System.out.println("car is turning off");
		this.engine.stop();
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
