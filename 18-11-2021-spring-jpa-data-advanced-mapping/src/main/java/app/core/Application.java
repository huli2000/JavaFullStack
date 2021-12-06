package app.core;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Product;
import app.core.entities.Store;
import app.core.exception.MallException;
import app.core.service.MallService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(Application.class, args);
		MallService service = ctx.getBean(MallService.class);
		
		try {
			
			Product p1 = new Product(0, "shirt", 200);
			Product p2 = new Product(0, "short", 220);
			Product p3 = new Product(0, "belt", 3);
			List<Product> products = Arrays.asList(p1, p2 , p3);
			Store store = new Store (0, "fox", products);
			service.addStore(store);
			
		
		
		List<Store> stores = service.getAllStoreInMall();
		System.out.println(stores);
	}catch (Exception e){
		System.out.println("Error: " + e.getMessage());
	}
	}
}
