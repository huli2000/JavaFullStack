package app.core.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import app.core.entities.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{
	
	List<Book> findByTitle(String title);
	List<Book> findById(int id);
	
//	Book findByTitle (String title);

//	// JPQL - use entity name
//		@Query
//		List<Book> getAllBooks();

//		void deleteById(List<Book> book);

//		@Query("select t.name from talmid t")
//		List<String> getNames();
//
//		// native SQL - use table name
//		@Query(value = "select  * from students where gender='M'", nativeQuery = true)
//		List<Student> getMales();
//
//		@Query("from talmid where age > :minAge")
//		List<Student> getOlderThan(int minAge);

}
