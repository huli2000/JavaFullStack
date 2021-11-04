package core.net;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringBootIntroApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootIntroApplication.class, args);
		String myEmail = ctx.getBean(String.class);
		System.out.println("my email: " + myEmail);
		
		Car car1 = ctx.getBean(Car.class);
		System.out.println(car1);
		Car car2 = ctx.getBean(Car.class);
		System.out.println(car2);
	}
	@Bean
	public String myEmail(@Value("${email}") String email)
	{
		return email;
	}
	

}
@Component
@Scope("prototype")
class Car {
	
	private int number = this.hashCode();
	private int speed;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	@Override
	public String toString() {
		return "Car [number=" + number + ", speed=" + speed + "]";
	}
	
	
}
