package app.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import app.core.beans.Order;

@Configuration
@ComponentScan
@PropertySource("application.properties")
public class App {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class)) {
			System.out.println("start - container is up");

			Order order = ctx.getBean("order1", Order.class);
			System.out.println(order);

		}
		System.out.println("stop - container is down");
	}

	@Bean
	
	public Order order1() {
		Order order = new Order("order 1 - tel aviv");
		return order;
	}

//	@Bean
//
//	public Order order2(@Qualifier("storeAddressB") String address) {
//		Order order = new Order(address);
//		return order;
//	}

	@Bean
	public String storeAddressA() {
		return "Ben Gurion Blvd , Jerusalem";
	}

	@Bean
	public String storeAddressB() {
		return "23rd Begin St. Haifa";
	}
}