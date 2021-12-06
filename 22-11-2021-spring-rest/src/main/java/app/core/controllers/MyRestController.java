package app.core.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyRestController {

	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public String helloWorld() {
		
		return "Hello World";
	}
	@RequestMapping(method = RequestMethod.GET, path = "/random")
	public double randomNumber() {
		System.out.println("rand");
		return (int)(Math.random()*101);
	}
	@GetMapping("/date")
	public LocalDateTime getDate() {
		LocalDateTime date = LocalDateTime.now();
		System.out.println("now asking for date " +date);
		return date;
	}
}
