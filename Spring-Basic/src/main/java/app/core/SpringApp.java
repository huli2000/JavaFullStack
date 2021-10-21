package app.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appCon.xml");
		
		Person p = ctx.getBean(Person.class);
		
		System.out.println(p);
		

	}

}
