package app.core;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import app.core.beans.MyComponent;


@ComponentScan
public class App {

	public static void main(String[] args) {

		System.out.println("start - container is up");
		
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class)) {

			MyComponent bean = ctx.getBean(MyComponent.class);
			bean.sayHi();
			
			try {
				TimeUnit.SECONDS.sleep(5);
				
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("stop - container is down");
	}

}