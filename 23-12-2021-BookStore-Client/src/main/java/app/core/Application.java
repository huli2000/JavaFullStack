package app.core;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import app.core.beans.Book;
import app.core.beans.BookWrapper;

public class Application {

	private static final int ParameterizedTypeReference = 0;

	public static void main(String[] args) {
		System.out.println("========Rest Template============");
		RestTemplate rt = new RestTemplate();

//		{ //get all book of a store
//			int storeId =5;
//			String url = "http://localhost:8080/api/store/wrapper"+ storeId;
//			BookWrapper wrapper = rt.getForObject(url,  BookWrapper.class);
//			List<Book> books = wrapper.getBooks();
//			System.out.println(books);
//		}

//		{ // get all book of a store
//			int storeId = 5;
//			String url = "http://localhost:8080/api/store/" + storeId;
//			ParameterizedTypeReference<List<Book>> type =new ParameterizedTypeReference<List<Book>>() {
//			};
//			rt.exchange(url, HttpMethod.GET, null, type);
//
//			System.out.println(type);
//		}
		
		int storeId =4;
		String url = "http://localhost:8080/api/store/" + storeId;
		Book[] arr = rt.getForObject(url,Book[].class);
		System.out.println(Arrays.toString(arr));
		
		// convert to list
		
		List<Book> list = Arrays.asList(arr);
		System.out.println(list);
		
		System.out.println("======== ========= ==============");
	}

}
