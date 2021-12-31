package tests;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;

import app.core.entities.Book;
import app.core.entities.BookStore;
import app.core.repo.BookRepo;
import app.core.repo.BookStoreRepo;

public class Test1Repo implements CommandLineRunner{

		private ApplicationContext ctx;
		
		public Test1Repo (ApplicationContext ctx) {
		super();
		this.ctx = ctx;
		}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("======test1repo======");
		addStoreWithBooks();
//		getStoreWithBooks();
	}
	
	public void getStoreWithBooks(int storeId) {
	BookStoreRepo bookStoreRepo = ctx.getBean(BookStoreRepo.class);
	BookRepo bookRepo = ctx.getBean(BookRepo.class);

	BookStore bookStore = bookStoreRepo.findById(storeId).orElse(null);
	if(bookStore != null) {
		System.out.println(bookStore);
		System.out.println(bookRepo.findByBookStoreId(storeId));
	
	}else {
		System.out.println("not found");
	}
	
	}
	public void addStoreWithBooks() {
		
		BookStoreRepo bookStoreRepo = ctx.getBean(BookStoreRepo.class);
	System.out.println(bookStoreRepo);
		
		Book book1 = new Book(0, "Sprin 1", " Dann", 500, LocalDate.of(2021, 1, 1),null);
		Book book2 = new Book(0, "Sprin 55", " Dann", 400, LocalDate.of(2018, 3, 9),null);
		Book book3 = new Book(0, "Sprin 3", " Dann", 533, LocalDate.of(2015, 2,7),null);
		Book book4 = new Book(0, "Sprin 4", " Dann", 230, LocalDate.of(2014, 5, 10),null);
		

		BookStore bookStore = new BookStore(0, "Sfarim Tlv", "Tel-Aviv", null);
		BookStore bookStore = new BookStore(0, "Sfarim JLM", "Jerusalem", null);
		bookStore.add(book1, book2, book3, book4);
		bookStore.add(book1, book2);
		
		bookStoreRepo.save(bookStore);
		System.out.println("Saved");
			
	}
	
	
	

}
