package app.core.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{
	
	Book findByTitle (String title);

	void deleteById(List<Book> book);

}
