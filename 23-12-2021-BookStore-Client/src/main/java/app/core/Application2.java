package app.core;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import app.core.beans.Book;
import app.core.beans.BookWrapper;

public class Application2 {

	private static final int ParameterizedTypeReference = 0;

	public static void main(String[] args) {
		System.out.println("========Rest Template============");
		RestTemplate rt = new RestTemplate();
		int storeId =4;
		String url = "http://localhost:8080/api/store/" + storeId ;
		Book book = new Book (0, "Alice", "cvcv", 88, LocalDate.now(), 4);
		int id = rt.postForObject(url, book, Integer.class);
		System.out.println("added book id " + id + " for store " +storeId);

		System.out.println("======== ========= ==============");
	}

}
