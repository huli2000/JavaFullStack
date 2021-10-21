package app.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Ship {
	
	@Autowired
	@Qualifier("shipEngine")
	
	private Engine engine;
	
	public void start() {
		System.out.println("ship is starting");
		this.engine.start();
		
	}
	public void stop() {
		System.out.println("ship is turning off");
		this.engine.stop();
	}

}
