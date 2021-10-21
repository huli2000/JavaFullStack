package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import app.core.beans.Car;
import app.core.beans.Person;

@Configuration
@ComponentScan
public class SpringApp3 {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringApp3.class);

		Car c1 = ctx.getBean("car", Car.class);
		Car c2 = ctx.getBean("fastCar", Car.class);
		System.out.println(c1);
		System.out.println(c2);
		ctx.close();

	}
	
	@Bean ()
	public Car fastCar() {
//		System.out.println("from bean method");
		Car car = new Car();
		car.setSpeed(100);
		return car;
		
		
	}

}
