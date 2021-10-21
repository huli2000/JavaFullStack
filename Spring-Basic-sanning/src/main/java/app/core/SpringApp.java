package app.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appCon.xml");
		
		Person p = ctx.getBean("thePerson", Person.class);
		Person p1 = ctx.getBean( "theOtherPerson",Person.class);
		
		System.out.println(p);
		System.out.println(p1);		
		
		Car car = ctx.getBean(Car.class);
		System.out.println(car);

	}

}
