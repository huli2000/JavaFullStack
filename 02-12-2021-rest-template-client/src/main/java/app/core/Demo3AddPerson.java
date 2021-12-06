package app.core;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import app.core.beans.Student;

public class Demo3AddPerson {

	public static void main(String[] args) {

		String baseUri = "http://localhost:8080/api";
		RestTemplate rt = new RestTemplate();

//		{ // add
//			Student student = new Student(102, "Danna", 18);
//			RequestEntity<Student> req = RequestEntity.method(HttpMethod.POST, baseUri + "/person").body(student);
//			ResponseEntity<Void> resp = rt.exchange(req, Void.class);
//			System.out.println(resp.getStatusCode());
//		}
//
//		{ // get all
//			RequestEntity<Void> req = RequestEntity.method(HttpMethod.GET, baseUri + "/all").build();
//			String resp = rt.exchange(req, String.class).getBody();
//			System.out.println(resp);
//		}

		{ // get all as Student[]
			RequestEntity<Void> req = RequestEntity.method(HttpMethod.GET, baseUri + "/all").build();
			Student[] arr = rt.exchange(req, Student[].class).getBody();
			System.out.println(Arrays.toString(arr));
		}

//		{ // get all as 
//			RequestEntity<Void> req = RequestEntity.method(HttpMethod.GET, baseUri + "/all").build();
//			List<Student> list = rt.exchange(req, List<Student>.class).getBody();
//			System.out.println(list);
//		}

		{ // get all as List<Student>

			ParameterizedTypeReference<List<Student>> listOfStudent = new ParameterizedTypeReference<>() {
			};
			List<Student> list = rt.exchange(baseUri + "/all", HttpMethod.GET, null, listOfStudent).getBody();
			System.out.println(list);
		}

	}

}
