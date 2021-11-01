package app.core;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.MyBean;

public class App1 {


	public static void main(String[] args) {

		System.out.println("START: container will open");
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(Config.class);
		MyBean bean = ctx.getBean("myBean", MyBean.class);
		System.out.println("using MyBean =========================");
		System.out.println(bean);
		System.out.println("======================================");
		System.out.println("END: container will close in 5 seconds");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ctx.close();
		System.out.println("container closed");
	}

}
