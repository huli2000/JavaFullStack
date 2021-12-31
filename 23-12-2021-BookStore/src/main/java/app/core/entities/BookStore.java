package app.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "books")
public class BookStore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	@OneToMany(mappedBy = "bookStore", cascade = CascadeType.ALL)
	private List<Book> books;

// add book to this store
	public void add(Book... books) {
		if (this.books == null) {
			this.books = new ArrayList<>();
		}
		for (Book b : books) {
			b.setBookStore(this);
			this.books.add(b);
		}

	}
	public void setBooks(List<Book> books ) {
		for (Book book : books) {
			book.setBookStore(this);
			
		}
		this.books = books;
		
	}

}
