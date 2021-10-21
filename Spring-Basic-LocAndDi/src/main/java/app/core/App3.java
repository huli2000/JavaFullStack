package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import app.core.beans.Car;
import app.core.beans.Ship;

@ComponentScan
public class App3 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App3.class)) {
			Car c1 = ctx.getBean(Car.class);
			System.out.println(c1);
			c1.start();
			c1.stop();
			
			Ship s1 =ctx.getBean(Ship.class);
					System.out.println(s1);
			s1.start();
			s1.stop();
		}

	}

}
