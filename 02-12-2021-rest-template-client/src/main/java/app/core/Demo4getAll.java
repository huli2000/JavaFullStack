package app.core;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import app.core.beans.Student;

public class Demo4getAll {

	public static void main(String[] args) {

		String baseUri = "http://localhost:8080/api";
		String path;
		RestTemplate rt = new RestTemplate();

		path = baseUri + "/all";
		{
			ResponseEntity<String> resp = rt.getForEntity(path, String.class);
			String allAsJson = resp.getBody();
			System.out.println(allAsJson);
		}
		{
			ResponseEntity<Student[]> resp = rt.getForEntity(path, Student[].class);
			Student[] arr = resp.getBody();
			System.out.println(Arrays.toString(arr));
		}

	}

}
