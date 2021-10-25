package app.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Order {

	private String storeAddressA;
	@Value("${store.email:xxx@gmail.com}")
	private String email;

	public Order(String storeAddress) {
	}

	
	public String getStoreAddress() {
		return storeAddressA;
	}

	public void setStoreAddress(String storeAddress, String storeAddressA) {
		this.storeAddressA = storeAddressA;
	}

	@Override
	public String toString() {
		String storeAddress = null;
		return "Order [storeAddress=" + storeAddress + "]";
	}

	public Order() {
		super();
	}

	public String getStoreAddressA() {
		return storeAddressA;
	}

	public void setStoreAddressA(String storeAddressA) {
		this.storeAddressA = storeAddressA;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
