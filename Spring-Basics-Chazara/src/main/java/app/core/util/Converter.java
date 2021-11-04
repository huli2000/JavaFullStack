package app.core.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Converter {
	@Value("${rate.nis}")
	private double nisExchangeRate;
	@Value("${rate.dollar}")
	private double dollarExchangeRate;

	public double nisToDollar(double nis) {

		return nis * this.dollarExchangeRate;

	}

	public double dollarToNis(double dollar) {

		return dollar * this.nisExchangeRate;
	}
}
