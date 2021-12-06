package app.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class Person {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int age;

}
