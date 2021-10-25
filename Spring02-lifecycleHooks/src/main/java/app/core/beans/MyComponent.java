package app.core.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {

public MyComponent () {
	
	System.out.println(">>> From MyComponent CTOR");
}

public void sayHi() {
	System.out.println("Hi");
	
}
@PostConstruct
public void createBean() {
	
	System.out.println(">>>Creat bean actions");
}
@PreDestroy
public void destroyBean() {
	
	System.out.println(">>>Destroy bean actions");
}

}
