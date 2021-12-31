package app.core.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Book;
import app.core.entities.BookStore;
import app.core.exception.BookStoreException;
import app.core.repo.BookRepo;
import app.core.repo.BookStoreRepo;

@Service
@Transactional(rollbackFor = app.core.exception.BookStoreException.class)
public class BookStoreService {

	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private BookStoreRepo bookStoreRepo;
	private BookStore store;

	// add store with books

	public int addStore(BookStore bookStore) {
		return this.bookStoreRepo.save(bookStore).getId();

	}

	// add books to exist store

	public void addBooks(int storeId, Book... books) throws BookStoreException {
		if (this.bookStoreRepo.existsById(storeId)) {
			BookStore store = this.bookStoreRepo.findById(storeId).get();
			store.add(books);
		} else {
			throw new BookStoreException("addBooks to store failed - store " + storeId + " not found");
		}
	}

	// get all books of a store
	public List<Book> getAllBook(int storeId) throws Exception {
		if (this.bookStoreRepo.existsById(storeId)) {
			store = this.bookStoreRepo.findById(storeId).get();
			return this.bookRepo.findByBookStoreId(storeId);
		} else {
			throw new Exception("getAllBooks of store failed - store " + storeId + " not found");
		}
	}

	// delete book

	public void deleteBook(int bookId) throws BookStoreException{
		try {
		this.bookRepo.deleteById(bookId);
		}catch (Exception e) {
			throw new BookStoreException("delete book failed - " +e.getMessage(), e);
		}
	}

	// delete store
	public void deleteStore(int storeId) {
		this.bookStoreRepo.deleteById(storeId);
	}

	// update a book
	public void updateBook(Book book) throws BookStoreException {
		Optional<Book> opt= bookRepo.findById(book.getId());
		if (opt.isPresent()) {
			Book bookFromDb = this.bookRepo.findById(book.getId()).get();
			bookFromDb.setAuthor(book.getAuthor());
			bookFromDb.setPrice(book.getPrice());
			bookFromDb.setPublication(book.getPublication());
			bookFromDb.setTitle(book.getTitle());
	
		} else {
			throw new BookStoreException("update book failed " + book + " not found");
		}

	}
//	// update a book
//		public void updateBook(Book book) throws BookStoreException {
//			if (this.bookRepo.existsById(book.getId())) {
//				Book bookFromDb = this.bookRepo.findById(book.getId()).get();
//				book.setBookStore(bookFromDb.getBookStore());
//				this.bookRepo.save(book);
//			} else {
//				throw new BookStoreException("update book failed " + book + " not found");
//			}
//
//		}
}

