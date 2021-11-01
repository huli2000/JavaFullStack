package app.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import app.core.beans.MyBean;

@Configuration
@ComponentScan
@PropertySource("application.properties")
public class Config {

	//@Bean
	public String str( ) {
	
		return "aaa";
	}
	//@Bean
	public MyBean myOtherBean() {
		return new MyBean();
	}
	
	
}
