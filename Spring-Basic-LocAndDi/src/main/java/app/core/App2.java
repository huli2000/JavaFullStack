package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import app.core.beans.School;

@ComponentScan
public class App2 {

	public static void main(String[] args) {
		
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App2.class))
				{
				System.out.println("context is up");
				ctx.getBean(School.class);
				}
	
		

	}

}
