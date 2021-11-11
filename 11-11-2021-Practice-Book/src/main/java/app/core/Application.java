package app.core;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Book;
import app.core.service.BookService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		BookService bookService = ctx.getBean(BookService.class);
		
//		try {
//			bookService.add(new Book (5, "xxxx222" , "xxxx112" , LocalDate.now(), 17.5,800));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		bookService.allBooks();
//		System.out.println(Book.class);
//	}

		
		try {
			bookService.delete(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	}
