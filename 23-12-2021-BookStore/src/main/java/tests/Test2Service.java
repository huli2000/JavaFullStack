package tests;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import app.core.entities.Book;
import app.core.exception.BookStoreException;
import app.core.services.BookStoreService;

public class Test2Service implements CommandLineRunner {

	private BookStoreService bookStoreService;

	public Test2Service(BookStoreService bookStoreService) {
		super();
		this.bookStoreService = bookStoreService;
	}

	@Override
	public void run(String... args) {
		System.out.println("======test1service2======");

		try {
	//		addBookToStore(3);
//			deleteBook(4);
//			deleteStore(88);
			updateBook();
		} catch (BookStoreException e) {
			System.err.println(e.getMessage());
		}
	}

	public void addBookToStore(int storeId) throws BookStoreException {

		bookStoreService.addBooks(3, new Book(0, "aaa", "moshe", 150, null, null));
		System.out.println("Books Added");
	}
	
	public void deleteBook(int bookId) throws BookStoreException{
		this.bookStoreService.deleteBook(bookId);
		System.out.println("deleted");
	}
	public void deleteStore(int storeId) throws BookStoreException{
		this.bookStoreService.deleteStore(storeId);
		System.out.println("deleted");
}
	public void updateBook() throws BookStoreException{
		Book book = new Book (111,"newBook", "Mark", 550,LocalDate.of(2000, 1, 20),null);
		this.bookStoreService.updateBook(book);
	}	
}