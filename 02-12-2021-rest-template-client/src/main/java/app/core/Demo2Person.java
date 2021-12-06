package app.core;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import app.core.beans.Student;

public class Demo2Person {

	public static void main(String[] args) {
		System.out.println("=== Demo 2 ===");

		// call greet as HTTP Client
		// we need a RestTemplate instance
		RestTemplate rt = new RestTemplate();

		String baseUri = "http://localhost:8080/api";

		// define a request object
		// http method: GET
		// uri: http://localhost:8080/api/greet
		RequestEntity<Void> req = RequestEntity.method(HttpMethod.GET, baseUri + "/person").build();

		// make the request and get the response
		ResponseEntity<Student> resp = rt.exchange(req, Student.class);

		// extract the data from the ResponseEntity instance
		int responseStatus = resp.getStatusCodeValue();
		Student student = resp.getBody();

		// print the response data
		System.out.println("================");
		System.out.println("status: " + responseStatus);
		System.out.println("body: " + student);

		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getAge());

	}

}
