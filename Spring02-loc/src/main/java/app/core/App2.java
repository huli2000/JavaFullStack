package app.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import app.core.beans.Order;

@Configuration
@ComponentScan
@PropertySource("application.properties")
public class App2 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App2.class)) {
			System.out.println("start - container is up");

			int beanCount = ctx.getBeanDefinitionCount();
			System.out.println("number of beans: " + beanCount);

			System.out.println("===================");

			String[] beanNames = ctx.getBeanDefinitionNames();
			for (String name : beanNames) {
				System.out.println(name);
			}
			System.out.println("@ component ===================");

			beanNames = ctx.getBeanNamesForAnnotation(Component.class);
			for (String name : beanNames) {
				System.out.println(name);
			}

			System.out.println("@ Bean ===================");

			beanNames = ctx.getBeanNamesForAnnotation(Bean.class);
			for (String name : beanNames) {
				System.out.println(name);
			}

			System.out.println("@ for type ===================");

			beanNames = ctx.getBeanNamesForType(Order.class);
			for (String name : beanNames) {
				System.out.println(name);
			}
			
			System.out.println("@ for String ===================");

			beanNames = ctx.getBeanNamesForType(String.class);
			for (String name : beanNames) {
				System.out.println(name);
			}
			
//			BeanDefinition beanDefinition = ctx.getBeanDefinition(app.core.beans.Order);
//			System.out.println(beanDefinition);
//		}
		System.out.println("stop - container is down");
	}

}
}