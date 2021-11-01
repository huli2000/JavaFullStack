package app.core.beans;

import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements BeanNameAware, InitializingBean, DisposableBean {
	@Value("${prop1:ERROR}")
	private String prop1;
	private String beanName;

	private int beanProcessOrder;
	private String beanSerial;
	private Scanner scanner;

	public MyBean() {
		System.out.println("=== MyBean CTOR =====");
		System.out.println(this);
		System.out.println("=====================");
	}

	@Override
	public String toString() {
		return "MyBean [prop1=" + prop1 + ", beanName=" + beanName + ", beanProcessOrder=" + beanProcessOrder
				+ ", beanSerial=" + beanSerial + ", scanner=" + scanner + "]";
	}
	// BeanNameAware

	public void setBeanName(String name) {
		this.beanName = name;
		System.out.println("setBeanName: BeanNameAware" + this);
	}

	public void setBeanProcessOrder(int beanProcessOrder) {
		this.beanProcessOrder = beanProcessOrder;
	}

	@PostConstruct
	public void myInitMethod() {
		System.out.println("***** @PostConstruct");
		this.beanSerial = "ser-00" + this.beanProcessOrder;
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("***** InitializingBean.afterPropertiesSet");
	}
	
	@PreDestroy
	public void myDestroyMethod () {
		this.scanner.close();
		System.out.println("scanner closed by @PreDestroyMethod");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("from DisposableBean.destroy");
		
	}
}

	
	