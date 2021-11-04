package app.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class UtilImp implements Util {
	@Autowired
	private Calculator calculator;
	@Autowired
		private Converter converter;
	

	@Override
	public int add(int a, int b) {
		return this.calculator.add(a, b);
	}

	@Override
	public double convertNisToDollar(double nis) {
		return this.converter.nisToDollar(nis);
	}
	

}
