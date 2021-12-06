package app.core.controllers;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
public class MyCRUDController {

	private List<String> names = new ArrayList<>();

	@GetMapping
	public List<String> getNames() {
		return this.names;
	}

//	private List<String> names = Arrays.asList("moshe", "avi", "eli");
//	
//	@GetMapping ("/get-names")
//	public List<String> getNames () {
//		return this.names;
//	}

	@PostMapping
	public String addName(@RequestParam String name) {
		this.names.add(name);
		return "name added";
	}

	@DeleteMapping("/deleteAll")
	public void delete() {
		this.names.clear();
	}
	// http://localhost:8080/crud/one?index=3
	@DeleteMapping("/one")
	public String delete1(@RequestParam int index) {
		try {

			String str = this.names.remove(index);
			return "remove: " + str;
		} catch (IndexOutOfBoundsException e) {
			return "remove name failed " + e.getMessage();
		}
	}
// http://localhost:8080/crud/one/3
	@DeleteMapping("/one/{index}")
	public String delete2(@PathVariable int index) {
		try {

			String str = this.names.remove(index);
			return "remove: " + str;
		} catch (IndexOutOfBoundsException e) {
			return "remove name failed " + e.getMessage();
		}
	}
}
