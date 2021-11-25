package app.core;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Book;
import app.core.repo.BookRepo;
import app.core.service.BookService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		BookService bookService = ctx.getBean(BookService.class);
		BookRepo bookRepo = ctx.getBean(BookRepo.class);

//		{
//			bookRepo.save(new Book(0, "Harry Potter", "Steven", LocalDate.of(2014, 7, 15), 145.20, 9));
//			bookRepo.save(new Book(0, "Harry Hirsh", "Moses", LocalDate.of(2009, 5, 5), 130.25, 22));
//			bookRepo.save(new Book(0, "Hello World", "Spring", LocalDate.now(), 35.85, 13));
//			bookRepo.save(new Book(0, "David Niser", "Yossi", LocalDate.of(2002, 8, 20), 5.25, 20));
//		}
		{
		try {
			bookService.add(new Book (0,"Harry Potter", "Steven", LocalDate.of(2014, 7, 15), 145.16, 9));
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

//		bookService.allBooks();
//		System.out.println(Book.class);
//	}

		{
			List<Book> list = bookRepo.findByTitle("Harry Potter");
			print(list);
		}
		{
			List<Book> list = bookRepo.findById(3);
			print(list);
		}
//		{
//			
//			System.out.println("========Start Deleting=========");
//			try {
//				bookRepo.deleteById(2);
//				
//			} catch (Exception e) {
//			
//			}
//			System.out.println("========Book Deleted=========");
//		}
		{
			List<Book> list = bookRepo.findAll();
			print(list);
		}

//		{
//			List<Book> list = 	bookRepo.getAllBooks();
//			print(list);
//			
//		}

//		try {
//			bookService.delete(2);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public static <T> void print(Collection<T> col) {
		System.out.println("==============Start============");
		for (T curr : col) {
			System.out.println(curr);
		}
		System.out.println("==============END==============");
	}
}