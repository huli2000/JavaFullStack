package app.core.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Book;
import app.core.repo.BookRepo;

@Transactional
@Service

public class BookService {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private BookRepo bookRepo;
	public int add(Book book) throws Exception{
		Book newBook = (Book) bookRepo.findByTitle(book.getTitle());
		if(newBook != null) {
			throw new Exception("Error: book with same name in DB");
		}else {
			book = bookRepo.save(book);
		}
//
//
//			
//		}
//
//			return book.getId();
//	}
//
//	public List<Book> find(int i) throws Exception {
//		TypedQuery<Book> query = em.createQuery("from Book", Book.class);
//		return query.getResultList();
//	}
//
//	public List<Book> allBooks() {
//
//		return this.bookRepo.findAll();
//
//	}
//	
//	public void update(Book book) throws Exception {
//		List<Book> bookFromDb = find(book.getId());
//		
//		
//	}
		return 0;


	
//	public void delete (int bookId) throws Exception {
//		List<Book> book = find(bookId);
//		this.bookRepo.deleteById(book);
//	}
		}
}
