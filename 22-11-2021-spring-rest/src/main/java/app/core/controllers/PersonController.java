package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Person;
import app.core.exceptions.PersonAppException;
import app.core.service.PersonService;

@RestController
@RequestMapping("/crud/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	@PostMapping (consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
	public int addPerson (@RequestBody Person person) {
		System.out.println(person);
		return this.personService.add(person);
	}
	@GetMapping (consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
	public List<Person> getAll(){
		return this.personService.getAll();
	}
	
	@GetMapping (path = "/{id}")
	public Person getPerson(@PathVariable int personId) {
		try {
			return this.personService.get(personId);
		} catch (PersonAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		}
	
	@PutMapping
	public boolean updatePerson (@RequestBody Person person) {
		return this.personService.update(person);
	}
	
	@DeleteMapping
	public String deletePerson (@RequestParam(name = "id") int personId) {
		return this.personService.delete(personId);
	}
}
