package app.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.core.entities.BookStore;

@Repository
public interface BookStoreRepo extends JpaRepository<BookStore, Integer> {

	
	
}
