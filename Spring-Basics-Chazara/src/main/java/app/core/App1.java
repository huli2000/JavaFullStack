package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App1 {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		Person person = ctx.getBean("person",Person.class);
		Person otherPerson = ctx.getBean("otherPerson", Person.class);
		Person person2 = ctx.getBean("person",Person.class);
		Person otherPerson2 = ctx.getBean("otherPerson2", Person.class);
		System.out.println(person.hashCode());
		System.out.println(otherPerson.hashCode());
		System.out.println(person2.hashCode());
		System.out.println(otherPerson.getName());
		System.out.println(otherPerson2.getId());

		ctx.close();
				
	}

}
