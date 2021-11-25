package app.core.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "company")
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String street;
	private int number;
	private String city;
	private String country;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
	private Company company;

	public Address(int id, String street, int number, String city, String country) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.city = city;
		this.country = country;
	}

}
