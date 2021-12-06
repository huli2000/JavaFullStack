package app.core;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Demo1Greet {

	public static void main(String[] args) {
		System.out.println("=== Demo 1 ===");

		// call greet as HTTP Client
		// we need a RestTemplate instance
		RestTemplate rt = new RestTemplate();

		String baseUri = "http://localhost:8080/api";

		// define a request object
		// http method: GET
		// uri: http://localhost:8080/api/greet
		RequestEntity<Void> req = RequestEntity.method(HttpMethod.GET, baseUri + "/greet/Avi").build();

		// make the request and get the response
		ResponseEntity<String> resp = rt.exchange(req, String.class);

		// extract the data from the ResponseEntity instance
		int responseStatus = resp.getStatusCodeValue();
		String responseBody = resp.getBody();

		// print the response data
		System.out.println("================");
		System.out.println("status: " + responseStatus);
		System.out.println("body: " + responseBody);

	}

}
