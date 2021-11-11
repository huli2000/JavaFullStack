package app.core.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode (of = "id")

public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String email;
	@Enumerated (EnumType.STRING)
	private Gender gender;
	private LocalDate enrolled;
	private boolean active;
	
	public enum Gender {
		F, M;
	}

}
