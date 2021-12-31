package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import app.core.services.BookStoreService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tests.Test1Repo;
import tests.Test2Service;

@SpringBootApplication
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
	public Test1Repo test1Repo(ApplicationContext ctx) {
		 
		return new Test1Repo(ctx);
	}
	
//	@Bean
	public Test2Service test2Service(BookStoreService bookStoreService) {
		 
		return new Test2Service(bookStoreService);
	}
}
