package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import app.core.beans.Car;
import app.core.beans.Person;

@ComponentScan
public class SpringApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringApp.class);

		Person p = ctx.getBean("thePerson", Person.class);

		System.out.println(p);
		
		Car car = ctx.getBean(Car.class);
		
		System.out.println(car);
		
		ctx.close();

	}

}
