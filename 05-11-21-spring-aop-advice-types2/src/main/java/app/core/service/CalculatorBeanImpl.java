package app.core.service;

import org.springframework.stereotype.Component;

@Component
public class CalculatorBeanImpl implements CalculatorBean {

	@Override
	public String div(int a, int b) throws RuntimeException {
		return a + " / " + b + " = " + (a / b) + "[remainder: " + (a % b) + "]";
	}

}
