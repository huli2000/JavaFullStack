package app.core.beans;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Counter extends Thread {
	@Override
		public void run() {
		int c =1; 
		while (true) {
			System.out.println(c++);
			try{
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				break;
			}
			
		}
		}

	@PostConstruct
	public void startMyCounter() {
		this.start();
		System.out.println(">>>count start");
	}
	@PreDestroy
	public void stopMyThread() {
		this.interrupt();
		System.out.println(">>>count stop");
	}
}
