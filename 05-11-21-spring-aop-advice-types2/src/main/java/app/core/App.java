package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.service.CalculatorBean;

public class App {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)) {

			CalculatorBean calc = ctx.getBean(CalculatorBean.class);
			String msg = calc.div(27, 8);
			System.out.println(msg);
		}

	}

}
