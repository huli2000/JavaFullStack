package app.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@ComponentScan
@Configuration
@PropertySource("application.properties")
public class Config {
	
	@Bean
	@Scope("singleton")
	public Person otherPerson (@Value("${person.name:NONE}") String name) {
		Person p = new Person();
		p.setName(name);
		return p;
	}
	@Bean
	@Scope("prototype")
	public Person otherPerson2 (@Value("${person.name:NONE}") String name) {
		Person p = new Person();
		p.setName(name);
		return p;
	}

}
