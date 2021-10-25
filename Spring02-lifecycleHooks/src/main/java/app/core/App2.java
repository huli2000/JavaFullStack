package app.core;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import app.core.beans.Counter;
import app.core.beans.MyComponent;

@ComponentScan
public class App2 {

	public static void main(String[] args) {
		System.out.println("start - container is up");
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App2.class) ;				
		System.out.println("main thread is going to sleep");	
		try {
				TimeUnit.SECONDS.sleep(10);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
	
			ctx.close();
		System.out.println("stop - container is down");
	}
	}
