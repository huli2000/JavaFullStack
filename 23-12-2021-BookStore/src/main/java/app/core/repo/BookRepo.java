package app.core.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {
	
	public List<Book> findByBookStoreId(int bookStoreId);
	

}
