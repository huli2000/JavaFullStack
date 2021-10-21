package app.core.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Primary
public class CarEngine implements Engine{
	private static int c = 101;
	private int number = c++;

	@Override
	public void start() {
System.out.println("car engine started #" + this.number);		
	}

	@Override
	public void stop() {
		System.out.println("car engine stopped #"+ this.number);	
		
	}
	
	

}
